package com.jeklsoft.example;

import static org.easymock.EasyMock.contains;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.jeklsoft.example.ImprovedRandomGame.guessResult;

@RunWith(EasyMockRunner.class)
public class TestImprovedRandomGameWithEasyMock {

    @Mock
    private ITargetGenerator generator;

    @Mock
    private PrintStream printStream;

    @Test
    public void testSimpleGame() {

        expect(generator.generate(10)).andReturn(3);
        replay(generator);

        printStream.println(contains("Welcome"));
        expectLastCall();
        printStream.println(contains("Too low"));
        expectLastCall().times(3);
        printStream.println(contains("Too high"));
        expectLastCall();
        printStream.println(contains("You got it in 5"));
        expectLastCall();
        replay(printStream);

        ImprovedRandomGame game = new ImprovedRandomGame(10, generator, printStream);

        verify(generator);

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

        verify(printStream);
    }
}
