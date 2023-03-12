package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

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
        Player easyPlayer = new Player(ApplicationProvider.getApplicationContext());
        easyPlayer.init(1, name, easy);
        assertEquals(5, easyPlayer.getLives());
    }

    @Test
    public void mediumLivesIs3() {
        DifficultyLevel medium = DifficultyLevel.MEDIUM;
        String name = "Test";
        Player mediumPlayer = new Player(ApplicationProvider.getApplicationContext());
        mediumPlayer.init(1, name, medium);
        assertEquals(3, mediumPlayer.getLives());
    }

    @Test
    public void hardLivesIs1() {
        DifficultyLevel hard = DifficultyLevel.HARD;
        String name = "Test";
        Player hardPlayer = new Player(ApplicationProvider.getApplicationContext());
        hardPlayer.init(1, name, hard);
        assertEquals(1, hardPlayer.getLives());
    }
}
