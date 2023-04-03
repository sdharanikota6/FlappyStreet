package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RiverTile;

import org.junit.Test;

public class keepScoreTest {
    @Test
    public void coveredRiverDoesNotCauseDeath() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "SD", DifficultyLevel.EASY);
        int oldScore = player.getScore();
        RiverTile riverTile = new RiverTile(ApplicationProvider.getApplicationContext());
        riverTile.cover();
        riverTile.step(player);
        assertEquals(oldScore, player.getScore());
    }
}