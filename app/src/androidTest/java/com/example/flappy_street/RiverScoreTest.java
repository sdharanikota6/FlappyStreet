package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RiverTile;

import org.junit.Test;

/**
 * Tests whether crossing a river correctly increments score.
 */
public class RiverScoreTest {
    @Test
    public void crossRoadIncrementsScore() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(1, "Holden", DifficultyLevel.EASY);
        int oldScore = player.getScore();
        RiverTile riverTile = new RiverTile(ApplicationProvider.getApplicationContext());
        riverTile.step(player);
        assertEquals(oldScore + 5, player.getScore());
    }
}
