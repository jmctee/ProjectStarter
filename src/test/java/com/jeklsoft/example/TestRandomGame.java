package com.jeklsoft.example;

import org.junit.Test;

public class TestRandomGame {

    @Test
    public void usedButNotTested() throws Exception {
        RandomGame game = new RandomGame(1);

        game.guess(-1);
        game.guess(0);
        game.guess(1);
    }
}
