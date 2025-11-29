package com.masarulmoin.MasarulMoin.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnitConverterController {

    @GetMapping("/convert")
    public String convert(
            @RequestParam String type,
            @RequestParam double value
    ) {

        type = type.toLowerCase();

        switch (type) {

            case "km-to-miles":
                return value + " km = " + (value * 0.621371) + " miles";

            case "miles-to-km":
                return value + " miles = " + (value * 1.60934) + " km";

            case "grams-to-kg":
                return value + " g = " + (value / 1000) + " kg";

            case "kg-to-grams":
                return value + " kg = " + (value * 1000) + " g";

            case "liters-to-ml":
                return value + " liters = " + (value * 1000) + " ml";

            case "ml-to-liters":
                return value + " ml = " + (value / 1000) + " liters";

            default:
                return "Invalid conversion type! Use: km-to-miles, miles-to-km, grams-to-kg, kg-to-grams, liters-to-ml, ml-to-liters";
        }
    }
}
