package com.example.flappy_street;

import static org.junit.Assert.*;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

import org.junit.Test;

public class MovementTest {

    /**
     * Tests if the player moves based on directionals.
     */
    @Test
    public void movementTestUp() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldY = player.getY();
        player.moveUp();
        float newY = player.getY();
        assertNotEquals(oldY, newY);
    }

    @Test
    public void movementTestDown() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        player.moveUp();
        float oldY = player.getY();
        player.moveDown();
        float newY = player.getY();
        assertNotEquals(oldY, newY);
    }

    @Test
    public void movementTestLeft() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldX = player.getX();
        player.moveLeft();
        float newX = player.getX();
        assertNotEquals(oldX, newX);
    }

    @Test
    public void movementTestRight() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldX = player.getX();
        player.moveRight();
        float newX = player.getX();
        assertNotEquals(oldX, newX);
    }
}
