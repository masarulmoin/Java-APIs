package com.masarulmoin.MasarulMoin;

import com.masarulmoin.MasarulMoin.Service.PrimeCheck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("hello")
@AllArgsConstructor
public class HelloController {
    private PrimeCheck primecheck;
    @GetMapping
    public String GetGratings() {
        return "Hello";
    }
    @GetMapping("primecheck/{number}")
    public String PrimeCheck(@PathVariable Integer number){
        return number+" is prime "+ primecheck.primecheck(number);
    }
}
