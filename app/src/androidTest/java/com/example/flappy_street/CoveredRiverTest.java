package com.example.flappy_street;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RiverTile;


import org.junit.Before;
import org.junit.Test;

public class CoveredRiverTest {
    @Test
    public void coveredRiverDoesNotCauseDeath() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "Holden", DifficultyLevel.EASY);
        int oldLives = player.getLives();
        RiverTile riverTile = new RiverTile(ApplicationProvider.getApplicationContext());
        riverTile.cover();
        riverTile.step(player);
        assertEquals(oldLives, player.getLives());
    }
}
