package pl.brych.hw_modul1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
//@Profile("premium")
public class PlusService {

//    @Value("${value.VAT}")
   int vatValue = 20;

    public int addVatService(int sum) {
        System.out.println(sum);
        int vat = (sum * vatValue) / 100;
        System.out.println(vat);
        System.out.println(sum + vat);
        return sum + vat;
    }
}
