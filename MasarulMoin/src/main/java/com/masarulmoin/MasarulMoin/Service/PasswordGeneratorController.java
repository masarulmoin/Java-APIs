package com.masarulmoin.MasarulMoin.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;

@RestController
public class PasswordGeneratorController {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+<>?";

    private static final String ALL = UPPER + LOWER + NUMBERS + SPECIAL;

    private static final SecureRandom random = new SecureRandom();

    @GetMapping("/generate-password")
    public String generatePassword(@RequestParam(defaultValue = "10") int length) {

        if (length < 4) {
            return "Password length must be at least 4 characters.";
        }

        StringBuilder password = new StringBuilder(length);

        // Ensure password contains at least one of each type
        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        // Fill the rest randomly
        for (int i = 4; i < length; i++) {
            password.append(ALL.charAt(random.nextInt(ALL.length())));
        }

        return password.toString();
    }
}