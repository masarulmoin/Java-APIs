package com.masarulmoin.MasarulMoin.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCounterController {

    @GetMapping("/word-counter")
    public String countWords(@RequestParam String text) {

        // Trim extra spaces
        String cleanedText = text.trim();

        if (cleanedText.isEmpty()) {
            return "Word count: 0 | Character count: 0";
        }

        // Split by one or more spaces
        String[] words = cleanedText.split("\\s+");
        int wordCount = words.length;

        int charCount = cleanedText.replace(" ", "").length();

        return "Word count: " + wordCount + " | Character count (no spaces): " + charCount;
    }
}