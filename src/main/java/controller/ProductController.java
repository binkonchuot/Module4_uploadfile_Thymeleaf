package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.io.File;

@Controller
public class ProductController {


    @GetMapping("/show")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("products", ProductService.products);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showcreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute(value = "product") Product product, @RequestParam MultipartFile upImg){
            String fileName = upImg.getOriginalFilename();
            try {
                //copy file vua tai va luu tru no tai thu muc minh muon
                FileCopyUtils.copy(upImg.getBytes(), new File("C:\\Users\\ADMIN\\IdeaProjects\\Demo_module4_Gradle1\\src\\main\\webapp\\WEB-INF\\img/" + fileName));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            product.setImg_product("/i/"+fileName);
        ProductService.save(product);
        ModelAndView modelAndView = new ModelAndView("redirect:/show");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showedit(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("products",ProductService.getProduct(id));
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Product product, @PathVariable int id,@RequestParam MultipartFile upImg){
        ModelAndView modelAndView = new ModelAndView("redirect:/show");
        String fileName = upImg.getOriginalFilename();
        try {
            //copy file vua tai va luu tru no tai thu muc minh muon
            FileCopyUtils.copy(upImg.getBytes(), new File("C:\\Users\\ADMIN\\IdeaProjects\\Demo_module4_Gradle1\\src\\main\\webapp\\WEB-INF\\img/" + fileName));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        product.setImg_product("/i/"+fileName);
         ProductService.edit(ProductService.findIndexById(id), product);
        return modelAndView;
    }
    @GetMapping("/delete")
    public String delete(@RequestParam int id){
       int index = ProductService.findIndexById(id);
       if(index >=0){
           ProductService.delete(index);
       }
       return "redirect:/show";
    }

}
