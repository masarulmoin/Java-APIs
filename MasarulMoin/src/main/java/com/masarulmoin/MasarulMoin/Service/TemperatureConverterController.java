package com.masarulmoin.MasarulMoin.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureConverterController {

    @GetMapping("/convert-temperature")
    public String convertTemperature(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam double value
    ) {
        from = from.toLowerCase();
        to = to.toLowerCase();

        double result;

        switch (from + "-to-" + to) {
            case "celsius-to-fahrenheit":
                result = (value * 9/5) + 32;
                return value + "°C = " + result + "°F";

            case "fahrenheit-to-celsius":
                result = (value - 32) * 5/9;
                return value + "°F = " + result + "°C";

            case "celsius-to-kelvin":
                result = value + 273.15;
                return value + "°C = " + result + "K";

            case "kelvin-to-celsius":
                result = value - 273.15;
                return value + "K = " + result + "°C";

            case "fahrenheit-to-kelvin":
                result = (value - 32) * 5/9 + 273.15;
                return value + "°F = " + result + "K";

            case "kelvin-to-fahrenheit":
                result = (value - 273.15) * 9/5 + 32;
                return value + "K = " + result + "°F";

            default:
                return "Invalid conversion! Supported: celsius-to-fahrenheit, fahrenheit-to-celsius, celsius-to-kelvin, kelvin-to-celsius, fahrenheit-to-kelvin, kelvin-to-fahrenheit";
        }
    }
}