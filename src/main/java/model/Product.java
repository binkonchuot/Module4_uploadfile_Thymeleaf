package model;

import org.springframework.web.multipart.MultipartFile;

public class Product {
    private int id_product;
    private String name_product;
    private String img_product;
    private String description;
    private String price;
    private MultipartFile upImg;

    public Product() {
    }

    public Product(int id_product, String name_product, String img_product, String description, String price) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.img_product = img_product;
        this.description = description;
        this.price = price;
    }

    public Product(int id_product, String name_product, String img_product, String description, String price, MultipartFile upImg) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.img_product = img_product;
        this.description = description;
        this.price = price;
        this.upImg = upImg;
    }

    public MultipartFile getUpImg() {
        return upImg;
    }

    public void setUpImg(MultipartFile upImg) {
        this.upImg = upImg;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getImg_product() {
        return img_product;
    }

    public void setImg_product(String img_product) {
        this.img_product = img_product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
