package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RoadTile;

import org.junit.Test;

/**
 * Tests whether restepping on a road tile maintains the same score.
 */
public class RoadRestepTest {
    @Test
    public void RoadRestepTest() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "Des", DifficultyLevel.EASY);
        int oldScore = player.getScore();
        RoadTile roadTile = new RoadTile(ApplicationProvider.getApplicationContext());
        roadTile.step(player);
        roadTile.step(player);
        assertEquals(oldScore + 1, player.getScore());
    }
}
