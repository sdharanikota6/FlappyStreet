package com.example.flappy_street;
import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RoadTile;


import org.junit.Before;
import org.junit.Test;

/**
 * Tests whether or not the player loses lives from stepping on a road tile.
 */

public class RoadTileTest {

    @Test
    public void stepOnRoadTile() {
        Player testPlayer = new Player(ApplicationProvider.getApplicationContext());
        testPlayer.init(0, "Des", DifficultyLevel.EASY);
        int before = testPlayer.getLives();
        RoadTile roadTile = new RoadTile(ApplicationProvider.getApplicationContext());
        if (roadTile.step(testPlayer) == roadTile) {
            assertEquals(before, testPlayer.getLives());
        }
    }


}