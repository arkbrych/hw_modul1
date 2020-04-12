package pl.brych.hw_modul1.model;

import lombok.Data;

@Data
public class Product {

    private String productName;
    private int productPrice;

    public Product(String productName, int productPrice){
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
