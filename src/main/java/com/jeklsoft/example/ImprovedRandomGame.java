package com.jeklsoft.example;

import java.io.PrintStream;

public class ImprovedRandomGame {

    private final int target;
    private final int highestValue;
    private final PrintStream outputStream;

    public enum guessResult {TOO_HIGH, TOO_LOW, JUST_RIGHT, ERROR}

    public enum gameState {NOT_STARTED, IN_PROGRESS, OVER}

    private int guessCount;
    private gameState state;

    public ImprovedRandomGame(int highestValue) {
        this(highestValue, new RandomTargetGenerator(), System.out);
    }

    ImprovedRandomGame(int highestValue, ITargetGenerator targetGenerator, PrintStream outputStream) {
        target = targetGenerator.generate(highestValue);
        this.outputStream = outputStream;
        this.highestValue = highestValue;

        guessCount = 0;
        state = gameState.NOT_STARTED;
    }

    public boolean startGame() {
        if (validateGame(gameState.NOT_STARTED)) {
            displayMessage("Welcome to this lame game!" +
             "\nWe're gonna ask you to guess a secret number <= " + highestValue + "." +
             "\nYou get as many guesses as you want, but try to keep it low ;)");

            state = gameState.IN_PROGRESS;

            return true;
        }
        else {
            displayMessage("Error");

            return false;
        }
    }

    public guessResult guess(int guess) {

        if (!validateGame(gameState.IN_PROGRESS)) {
            displayMessage("Error2");
            return guessResult.ERROR;
        }

        guessResult result;
        guessCount++;

        if(guess < target) {
            result = guessResult.TOO_LOW;
            displayMessage("\nToo low, try again.\n");
        }
        else if(guess > target) {
            result = guessResult.TOO_HIGH;
            displayMessage("\nToo high, try again.\n");
        }
        else {
            result = guessResult.JUST_RIGHT;
            state = gameState.OVER;

            displayMessage("\nYou got it in " + guessCount +
                    " guesses!  You rock.\n");
        }

        return result;
    }

    public int getGuessCount() {
        return guessCount;
    }

    private boolean validateGame(gameState expectedState) {
        return state == expectedState;
    }

    private void displayMessage(String message) {
        outputStream.println(message);
    }
}