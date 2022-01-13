package service;

import model.Product;

import java.util.ArrayList;

public class ProductService {
    public static ArrayList<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1,"xe moto","https://kenh14cdn.com/203336854389633024/2022/1/10/photo-1-16417479468001775510619.jpg","xe an trom","700 trieu"));
        products.add(new Product(2,"xe oto","https://kenh14cdn.com/203336854389633024/2022/1/10/photo-1-16417479468001775510619.jpg","xe an trom","700 trieu"));
        products.add(new Product(3,"xe dap","https://kenh14cdn.com/203336854389633024/2022/1/10/photo-1-16417479468001775510619.jpg","xe an trom","700 trieu"));
    }

    public static void save(Product product){
        products.add(product);
    }
    public static void edit(int index, Product product){
        products.set(index, product);
    }
    public static Product getProduct(int id){
        return products.get(findIndexById(id));
    }
    public static void delete(int index){
        products.remove(index);
    }

    public static int findIndexById(int id){
        for (int i = 0; i< products.size(); i++) {
        if (products.get(i).getId_product() == id){
            return i;
        }
        } return  -1;
    }
}
