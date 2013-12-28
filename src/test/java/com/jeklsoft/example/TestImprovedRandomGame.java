package com.jeklsoft.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jeklsoft.example.ImprovedRandomGame.guessResult;

public class TestImprovedRandomGame {

    @Test
    public void testSimpleGame() {
        ImprovedRandomGame game = new ImprovedRandomGame(10, new ITargetGenerator() {
            @Override
            public int generate(int highestValue) {
                return 3;
            }
        }, System.out);

        game.startGame();

        assertEquals(0, game.getGuessCount());

        guessResult result;

        result = game.guess(-1);
        assertEquals(guessResult.TOO_LOW, result);

        result = game.guess(0);
        assertEquals(guessResult.TOO_LOW, result);

        result = game.guess(4);
        assertEquals(guessResult.TOO_HIGH, result);

        result = game.guess(1);
        assertEquals(guessResult.TOO_LOW, result);

        result = game.guess(3);
        assertEquals(guessResult.JUST_RIGHT, result);

        assertEquals(5, game.getGuessCount());
    }
}
