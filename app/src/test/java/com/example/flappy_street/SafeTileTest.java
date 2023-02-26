package com.example.flappy_street;
import static org.junit.Assert.assertEquals;

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
        SafeTile safeTile = new SafeTile(null);
        Player testPlayer = new Player("Robert", DifficultyLevel.EASY);
        int before = testPlayer.getLives();
        if (safeTile.step(testPlayer) == safeTile) {
            assertEquals(before, testPlayer.getLives());
        }
    }


}
