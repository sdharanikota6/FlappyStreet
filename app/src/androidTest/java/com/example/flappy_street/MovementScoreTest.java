package com.example.flappy_street;

import static org.junit.Assert.*;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

import org.junit.Test;

public class MovementScoreTest {

    /**
     * Tests to make sure the score does not increment if the player moves backwards or sideways.
     */

    @Test
    public void scoreDown() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldScore = player.getScore();
        player.moveDown();
        float newScore = player.getScore();
        assertEquals(oldScore, newScore, 0);
    }
    @Test
    public void scoreLeft() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldScore = player.getScore();
        player.moveLeft();
        float newScore = player.getScore();
        assertEquals(oldScore, newScore, 0);
    }
    @Test
    public void scoreRight() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldScore = player.getScore();
        player.moveRight();
        float newScore = player.getScore();
        assertEquals(oldScore, newScore, 0);
    }
}