package pl.brych.hw_modul1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile("premium")
public class PremiumService {

    @Value("${value.discount}")
    int discountValue;

    private PlusService plusService;

    public PremiumService(PlusService plusService) {
        this.plusService = plusService;
    }

//    public int addDiscountService() {
//        int sum = plusService.addVatService();
//        int discount = (sum * discountValue) / 100;
//        return sum - discount;
//    }
}
