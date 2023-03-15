package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

import org.junit.Test;

/**
 * Tests that the player's score correctly updates upon a win.
 */
public class PlayerWinUnitTest {
    @Test
    public void winIncreasesScore() {
        DifficultyLevel easy = DifficultyLevel.EASY;
        String name = "Test";
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, name, easy);
        player.setScore(0);
        player.win();
        assertEquals(100, player.getScore());
    }
}
