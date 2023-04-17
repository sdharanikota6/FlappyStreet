package com.example.flappy_street;

import static org.junit.Assert.*;
import androidx.test.core.app.ApplicationProvider;
import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import org.junit.Test;

public class SnapHorizontalTest {
    /**
     * Tests if moving up snaps horizontal position.
     */
    @Test
    public void snapUpHorizontalTest() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "Holden", DifficultyLevel.EASY);
        player.moveRight();
        player.moveLeft();
        float oldX = player.getX();
        player.setX(oldX + 1);
        player.moveUp();
        assertEquals(oldX, player.getX(), 0);
    }

    /**
     * Tests if moving down snaps horizontal position.
     */
    @Test
    public void snapDownHorizontalTest() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "Holden", DifficultyLevel.EASY);
        player.moveRight();
        player.moveLeft();
        player.moveUp();
        float oldX = player.getX();
        player.setX(oldX + 1);
        player.moveDown();
        assertEquals(oldX, player.getX(), 0);
    }

    /**
     * Tests if moving left and right snaps horizontal position.
     */
    @Test
    public void snapLeftRightHorizontalTest() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "Holden", DifficultyLevel.EASY);
        player.moveRight();
        player.moveLeft();
        float oldX = player.getX();
        player.setX(oldX + 1);
        player.moveRight();
        player.moveLeft();
        assertEquals(oldX, player.getX(), 0);
    }
}
