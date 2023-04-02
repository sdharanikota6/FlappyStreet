package com.example.flappy_street;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.tiles.RiverTile;


import org.junit.Before;
import org.junit.Test;

public class UncoveredRiverTest {
    @Test
    public void uncoveredRiverDoesCauseDeath() {
        GameLevel gameLevel = new GameLevel(ApplicationProvider.getApplicationContext());
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.setGameLevel(gameLevel);
        player.init(0, "Holden", DifficultyLevel.EASY);
        int oldLives = player.getLives();
        RiverTile riverTile = new RiverTile(ApplicationProvider.getApplicationContext());
        riverTile.uncover();
        riverTile.step(player);
        assertEquals(oldLives - 1, player.getLives());
    }
}
