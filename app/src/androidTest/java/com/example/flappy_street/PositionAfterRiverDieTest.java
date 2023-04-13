package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RiverTile;

import org.junit.Test;

/**
 * Tests if the player returns to the initial tile before receiving damage from a RiverTile.
 */

public class PositionAfterRiverDieTest {
    @Test
    public void positionIsInitial() {
        Player testPlayer = new Player(ApplicationProvider.getApplicationContext());
        testPlayer.init(0, "gwu", DifficultyLevel.EASY);
        int before = testPlayer.getLives();
        RiverTile riverTile = new RiverTile(ApplicationProvider.getApplicationContext());
        float beforeX = testPlayer.getX();
        float beforeY = testPlayer.getY();
        while (riverTile.step(testPlayer) != riverTile) {
            beforeX = testPlayer.getX();
            beforeY = testPlayer.getY();
        }
        if (riverTile.step(testPlayer) == riverTile) {
            assertEquals(beforeX, testPlayer.getX(), 1);
            assertEquals(beforeY, testPlayer.getY(), 1);
        }
    }
}
