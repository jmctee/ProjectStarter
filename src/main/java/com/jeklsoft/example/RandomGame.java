package com.jeklsoft.example;

import java.util.Date;
import java.util.Random;

public class RandomGame {

    private final int target;
    private int guessCount;

    public RandomGame(int highestValue) {
        target = new Random(new Date().getTime()).nextInt(highestValue + 1);
        guessCount = 0;

        displayMessage("Welcome to this lame game!" +
         "\nWe're gonna ask you to guess a secret number <= " + highestValue + "." +
         "\nYou get as many guesses as you want, but try to keep it low ;)");
    }

    public void guess(int guess) {
        guessCount++;

        if(guess < target) {
            displayMessage("\nToo low, try again.\n");
        }
        else if(guess > target) {
            displayMessage("\nToo high, try again.\n");
        }
        else {
            displayMessage("\nYou got it in " + guessCount +
                    " guesses!  You rock.\n");
        }
    }

    private void displayMessage(String message) {
        System.out.println(message);
    }
}