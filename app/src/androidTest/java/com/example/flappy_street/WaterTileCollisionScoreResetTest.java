package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RiverTile;

import org.junit.Assert;
import org.junit.Test;

/**
 * test to see if the player's score resets to 0 once they step on a watertile.
 */

public class WaterTileCollisionScoreResetTest {
    @Test
    public void checkScoreReset() {
        Player testplayer = new Player(ApplicationProvider.getApplicationContext());
        testplayer.init(0, "des", DifficultyLevel.EASY);
        int afterscore = testplayer.getScore();
        RiverTile rivertile = new RiverTile(ApplicationProvider.getApplicationContext());
        while (rivertile.step(testplayer) != rivertile) {
            afterscore = testplayer.getScore();
        }
        if (rivertile.step(testplayer) == rivertile) {
            afterscore = testplayer.getScore();
            assertEquals(afterscore, 0);
        }
    }
}
