package com.jeklsoft.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.Test;

import com.jeklsoft.example.ImprovedRandomGame.guessResult;

public class TestImprovedRandomGameWithMockito {
    @Test
    public void testSimpleGame() {
        ITargetGenerator mockGenerator = mock(ITargetGenerator.class);
        stub(mockGenerator.generate(10)).toReturn(3);

        PrintStream mockStream = mock(PrintStream.class);

        ImprovedRandomGame game = new ImprovedRandomGame(10, mockGenerator, mockStream);

        verify(mockGenerator).generate(10);

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

        verify(mockStream, times(1)).println(contains("Welcome"));
        verify(mockStream, times(3)).println(contains("Too low"));
        verify(mockStream, times(1)).println(contains("Too high"));
        verify(mockStream, times(1)).println(contains("You got it in 5"));
    }
}
