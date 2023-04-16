package com.example.flappy_street;

import static org.junit.Assert.*;
import androidx.test.core.app.ApplicationProvider;
import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import org.junit.Test;

public class SnapVerticalTest {
    /**
     * Test if moving right snaps vertical position.
     */
    @Test
    public void snapRightVerticalTest() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "Holden", DifficultyLevel.EASY);
        player.moveUp();
        player.moveDown();
        float oldY = player.getY();
        player.setY(oldY + 1);
        player.moveRight();
        assertEquals(oldY, player.getY(), 0);
    }

    /**
     * Test if moving left snaps vertical position.
     */
    @Test
    public void snapLeftVerticalTest() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "Holden", DifficultyLevel.EASY);
        player.moveUp();
        player.moveDown();
        float oldY = player.getY();
        player.setY(oldY + 1);
        player.moveLeft();
        assertEquals(oldY, player.getY(), 0);
    }

    /**
     * Test if moving up and down snaps vertical position.
     */
    @Test
    public void snapUpDownVerticalTest() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "Holden", DifficultyLevel.EASY);
        player.moveUp();
        player.moveDown();
        float oldY = player.getY();
        player.setY(oldY + 1);
        player.moveUp();
        player.moveDown();
        assertEquals(oldY, player.getY(), 0);
    }
}
