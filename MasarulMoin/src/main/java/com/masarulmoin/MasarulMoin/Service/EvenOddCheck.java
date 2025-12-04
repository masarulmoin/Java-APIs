package com.masarulmoin.MasarulMoin;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EvenOddCheck {

    // GET: Check even or odd using path variable
    @GetMapping("/check/{number}")
    public String checkGet(@PathVariable int number) {
        return checkEvenOdd(number);
    }

    // POST: Check even or odd using request body
    @PostMapping("/check")
    public String checkPost(@RequestBody int number) {
        return checkEvenOdd(number);
    }

    // PUT: Update number and check again
    @PutMapping("/check")
    public String checkPut(@RequestParam int number) {
        return checkEvenOdd(number);
    }

    // DELETE: Return a message (usually delete removes data)
    @DeleteMapping("/check/{number}")
    public String deleteCheck(@PathVariable int number) {
        return "DELETE called, nothing removed. Number was: " + number;
    }

    // COMMON FUNCTION
    private String checkEvenOdd(int number) {
        if (number % 2 == 0)
            return number + " is EVEN.";
        else
            return number + " is ODD.";
    }
}
