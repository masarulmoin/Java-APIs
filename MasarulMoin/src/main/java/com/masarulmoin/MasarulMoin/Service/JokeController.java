package com.masarulmoin.MasarulMoin.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class JokeController {

    private final String[] jokes = {
            "Why don't scientists trust atoms? Because they make up everything!",
            "I'm reading a book about anti-gravity. It's impossible to put down!",
            "Why did the math book look sad? Because it had too many problems.",
            "What do you call fake spaghetti? An impasta!",
            "Why did the scarecrow win an award? Because he was outstanding in his field!",
            "What do you call cheese that isn't yours? Nacho cheese!",
            "Why don't programmers like nature? Too many bugs.",
            "Why was the computer cold? It forgot to close Windows.",
            "Why do cows have hooves instead of feet? Because they lactose.",
            "Why don't eggs tell jokes? They'd crack each other up!"
    };

    @GetMapping("/random-joke")
    public String getRandomJoke() {
        Random random = new Random();
        int index = random.nextInt(jokes.length);
        return jokes[index];
    }
}