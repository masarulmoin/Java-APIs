package com.masarulmoin.MasarulMoin.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencySymbolController {

    private static final Map<String, String> currencyMap = new HashMap<>();

    static {
        currencyMap.put("USD", "$");
        currencyMap.put("INR", "₹");
        currencyMap.put("EUR", "€");
        currencyMap.put("GBP", "£");
        currencyMap.put("JPY", "¥");
        currencyMap.put("AUD", "A$");
        currencyMap.put("CAD", "C$");
        currencyMap.put("CHF", "CHF");
        currencyMap.put("CNY", "¥");
        currencyMap.put("ZAR", "R");
    }

    @GetMapping("/currency-symbol")
    public String getCurrencySymbol(@RequestParam String code) {

        String upperCode = code.toUpperCase();

        if (currencyMap.containsKey(upperCode)) {
            return "Currency: " + upperCode + " | Symbol: " + currencyMap.get(upperCode);
        } else {
            return "Invalid currency code: " + code;
        }
    }
}