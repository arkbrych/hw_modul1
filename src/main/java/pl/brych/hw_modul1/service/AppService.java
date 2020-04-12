package pl.brych.hw_modul1.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.brych.hw_modul1.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Data
public class AppService {

    private List<Product> productList;
    private PlusService plusService;
    private PremiumService premiumService;

    private int priceSum;
    private int priceGross;
    private int priceWithDiscount;

    public AppService(PlusService plusService, PremiumService premiumService) {
        this.plusService = plusService;
        this.premiumService = premiumService;
        initializer();
    }

    public void initializer() {
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
        priceSum = 0;
        for (Product product : productList) {
            priceSum = priceSum + product.getProductPrice();
        }
        setPriceSum(priceSum);
        return priceSum;
    }

    public Product createProduct(Product product) {
        Product newProduct = new Product(product.getProductName(), product.getProductPrice());
        productList.add(newProduct);
        return newProduct;
    }

    public int addVat() {
        priceGross = plusService.addVatService(priceSum);
        setPriceGross(priceGross);
        return priceGross;
    }

    public int addDiscount() {
        priceWithDiscount = premiumService.addDiscountService(priceGross);
        setPriceWithDiscount(priceWithDiscount);
        return priceWithDiscount;
    }
}
