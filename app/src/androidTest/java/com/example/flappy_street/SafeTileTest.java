package com.example.flappy_street;
import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.SafeTile;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests whether or not the player loses lives from stepping on a safe tile.q
 */

public class SafeTileTest {

    @Test
    public void stepOnSafeTile() {
        Player testPlayer = new Player(ApplicationProvider.getApplicationContext());
        testPlayer.init(0, "Rober", DifficultyLevel.EASY);
        int before = testPlayer.getLives();
        SafeTile safeTile = new SafeTile(ApplicationProvider.getApplicationContext());
        if (safeTile.step(testPlayer) == safeTile) {
            assertEquals(before, testPlayer.getLives());
        }
    }


}
