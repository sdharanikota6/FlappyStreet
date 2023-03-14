package com.example.flappy_street;

import static org.junit.Assert.*;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

import org.junit.Test;
public class PlayerBoundaryTest {

    /**
     * Tests if a border keeps the player from moving infinitely.
     */
    @Test
    public void bottomBorder() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldY = player.getY();
        player.moveDown();
        float newY = player.getY();
        while(oldY != newY) {
            oldY = newY;
            player.moveDown();
            newY = player.getY();
        }
        assertEquals(oldY, newY, 0);
    }

    @Test
    public void topBorder() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldY = player.getY();
        player.moveUp();
        float newY = player.getY();
        while(oldY != newY) {
            oldY = newY;
            player.moveUp();
            newY = player.getY();
        }
        assertEquals(oldY, newY, 0);
    }

    @Test
    public void leftBorder() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldX = player.getX();
        player.moveLeft();
        float newX = player.getX();
        while(oldX != newX) {
            oldX = newX;
            player.moveLeft();
            newX = player.getX();
        }
        assertEquals(oldX, newX, 0);
    }

    @Test
    public void rightBorder() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldX = player.getX();
        player.moveRight();
        float newX = player.getX();
        while(oldX != newX) {
            oldX = newX;
            player.moveRight();
            newX = player.getX();
        }
        assertEquals(oldX, newX, 0);
    }
}