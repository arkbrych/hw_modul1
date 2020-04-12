package pl.brych.hw_modul1.service;

import org.springframework.stereotype.Component;
import pl.brych.hw_modul1.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class AppService {

    private List<Product> productList;
    private PlusService plusService;
    private PremiumService premiumService;

    private int tester = 1000;

    public AppService() {
        Product product1 = new Product("Monitor", priceGenerator());
        Product product2 = new Product("Myszka", priceGenerator());
        Product product3 = new Product("Klawiatura", priceGenerator());
        Product product4 = new Product("Czosnek", priceGenerator());
        Product product5 = new Product("Laptop", priceGenerator());
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    public AppService(PlusService plusService, PremiumService premiumService) {
        this.plusService = plusService;
        this.premiumService = premiumService;
    }

    private int priceGenerator() {
        int min = 50;
        int max = 300;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int calculatePriceSum() {
        int priceSummary = 0;
        for (Product product : productList) {
            priceSummary = priceSummary + product.getProductPrice();
        }
        return priceSummary;
    }

    public Product createProduct(Product product) {
        Product newProduct = new Product(product.getProductName(), product.getProductPrice());
        productList.add(newProduct);
        return newProduct;
    }

    public int addVat() {

        return plusService.addVatService(tester);
    }

//    public int addDiscount() {
//        return premiumService.addDiscountService();
//    }
}
