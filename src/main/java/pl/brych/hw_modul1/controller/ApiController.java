package pl.brych.hw_modul1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.brych.hw_modul1.model.Product;
import pl.brych.hw_modul1.service.AppService;
import pl.brych.hw_modul1.service.PlusService;
import pl.brych.hw_modul1.service.PremiumService;

import java.util.List;

@RestController
public class ApiController {

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
    public String showGrossPrice() {
        return "Cena BRUTTO wszystkich produktów wynosi: " + appService.addVat();
    }

//    @GetMapping("/giveDiscount")
//    public String showGrossPriceWithDiscount() {
//        return "Cena BRUTTO po przyznaniu rabatu: " + appService.addDiscount();
//    }


}
