package com.example.flappy_street;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RiverTile;


import org.junit.Before;
import org.junit.Test;

/**
 * Tests whether or not the player loses a life from stepping on a river tile.
 */

public class RiverTileTest {

    @Test
    public void stepOnRiverTile() {
        Player testPlayer = new Player(ApplicationProvider.getApplicationContext());
        testPlayer.init(0, "Des", DifficultyLevel.EASY);
        int before = testPlayer.getLives();
        RiverTile riverTile = new RiverTile(ApplicationProvider.getApplicationContext());
        if (riverTile.step(testPlayer) == riverTile) {
            assertEquals(before - 1, testPlayer.getLives());
        }
    }
}