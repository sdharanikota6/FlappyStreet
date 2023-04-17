package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RoadTile;

import org.junit.Test;

public class CoinScoreTest {
    @Test
    public void CoinStepIncrementsScore() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "SD", DifficultyLevel.EASY);
        int score = player.getScore();
        RoadTile coinTile = new RoadTile(ApplicationProvider.getApplicationContext(), true);
        coinTile.step(player);
        assertEquals(score + 4, player.getScore());
    }
}
