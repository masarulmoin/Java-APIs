package com.masarulmoin.MasarulMoin.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {

    @GetMapping("/discount")
    public String calculateDiscount(
            @RequestParam double price,
            @RequestParam double discount
    ) {
        if (price <= 0 || discount < 0 || discount > 100) {
            return "Invalid input! Price must be > 0 and discount must be between 0 and 100.";
        }

        double discountAmount = (price * discount) / 100;
        double finalPrice = price - discountAmount;

        return "Original Price: " + price +
                " | Discount: " + discount + "%" +
                " | Discount Amount: " + discountAmount +
                " | Final Price: " + finalPrice;
    }
}