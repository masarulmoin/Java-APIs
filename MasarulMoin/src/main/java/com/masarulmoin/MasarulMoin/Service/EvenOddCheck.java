package com.masarulmoin.MasarulMoin.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvenOddCheck {
    @GetMapping("/check")
    public String checkEvenOdd(@RequestParam int number) {

        if (number % 2 == 0) {
            return number + " is EVEN";
        } else {
            return number + " is ODD";
        }
    }
}
