package pl.brych.hw_modul1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PremiumService {

    @Value("${value.discount}")
    int discountValue;

    public int addDiscountService(int grossPrice) {
        int discount = (grossPrice * discountValue) / 100;
        return grossPrice - discount;
    }
}
