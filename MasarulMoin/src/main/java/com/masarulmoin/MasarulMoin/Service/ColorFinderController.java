package com.masarulmoin.MasarulMoin.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ColorFinderController {

    private static final Map<String, String> colorMap = new HashMap<>();

    static {
        colorMap.put("#FF0000", "Red");
        colorMap.put("#00FF00", "Green");
        colorMap.put("#0000FF", "Blue");
        colorMap.put("#FFFF00", "Yellow");
        colorMap.put("#FFA500", "Orange");
        colorMap.put("#800080", "Purple");
        colorMap.put("#000000", "Black");
        colorMap.put("#FFFFFF", "White");
        colorMap.put("#808080", "Gray");
        colorMap.put("#FFC0CB", "Pink");
    }

    @GetMapping("/color-name")
    public String getColorName(@RequestParam String hex) {

        String upperHex = hex.toUpperCase();

        if (!upperHex.startsWith("#")) {
            upperHex = "#" + upperHex;
        }

        if (colorMap.containsKey(upperHex)) {
            return "Color: " + colorMap.get(upperHex);
        }

        return "Unknown color for HEX: " + hex;
    }
}