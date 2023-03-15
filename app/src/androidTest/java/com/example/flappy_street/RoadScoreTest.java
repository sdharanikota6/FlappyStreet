package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RoadTile;

import org.junit.Test;

/**
 * Tests whether crossing a road correctly increments score.
 */
public class RoadScoreTest {
    @Test
    public void crossRoadIncrementsScore() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "Holden", DifficultyLevel.EASY);
        int oldScore = player.getScore();
        RoadTile roadTile = new RoadTile(ApplicationProvider.getApplicationContext());
        roadTile.step(player);
        assertEquals(oldScore + 1, player.getScore());
    }
}
