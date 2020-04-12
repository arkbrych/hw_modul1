package pl.brych.hw_modul1.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.brych.hw_modul1.model.Product;
import pl.brych.hw_modul1.service.AppService;

import java.util.List;

@RestController
@Data
public class ApiController {

    @Value("${spring.profiles.active}")
    private String activeProfiles;

    private AppService appService;

    public ApiController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return appService.getProductList();
    }

    @GetMapping("/sum")
    public String getSum() {
        return "Cena NETTO wszystkich produktów wynosi: " + appService.calculatePriceSum();
    }

    @PostMapping("/addProduct")
    public Product createProduct(@RequestBody Product product) {
        return appService.createProduct(product);
    }

    @GetMapping("/grossPrice")
    public String showGrossPrice() throws Exception {
        System.out.println(getActiveProfiles());
        if (!getActiveProfiles().equals("start")) {
            return "Cena BRUTTO wszystkich produktów wynosi: " + appService.addVat();
        } else throw new Exception("Z tej funkcjonalności nie może korzystać profil START");
    }

    @GetMapping("/giveDiscount")
    public String showGrossPriceWithDiscount() throws Exception {
        if (!getActiveProfiles().equals("start") && !getActiveProfiles().equals("plus")) {
            return "Cena BRUTTO po przyznaniu rabatu: " + appService.addDiscount();
        } else throw new Exception("Z tej funkcjonalności może korzystać tylko profil PREMIUM");
    }


}
