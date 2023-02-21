package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

import org.junit.Test;

/**
 * Tests that the player difficulty correctly sets the number of lives.
 */
public class PlayerDifficultyUnitTest {
    @Test
    public void easyLivesIs5() {
        DifficultyLevel easy = DifficultyLevel.EASY;
        String name = "Test";
        Player easyPlayer = new Player(name, easy);
        assertEquals(5, easyPlayer.getLives());
    }

    @Test
    public void mediumLivesIs3() {
        DifficultyLevel medium = DifficultyLevel.MEDIUM;
        String name = "Test";
        Player mediumPlayer = new Player(name, medium);
        assertEquals(3, mediumPlayer.getLives());
    }

    @Test
    public void hardLivesIs1() {
        DifficultyLevel hard = DifficultyLevel.HARD;
        String name = "Test";
        Player hardPlayer = new Player(name, hard);
        assertEquals(1, hardPlayer.getLives());
    }
}
