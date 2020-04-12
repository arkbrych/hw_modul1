package pl.brych.hw_modul1.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PlusService {

    @Value("${value.VAT}")
    int vatValue;

    public int addVatService(int sum) {
        int vat = (sum * vatValue) / 100;
        return sum + vat;
    }
}
