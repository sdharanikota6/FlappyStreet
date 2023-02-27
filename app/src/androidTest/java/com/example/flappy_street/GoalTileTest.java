package com.example.flappy_street;
import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.GoalTile;


import org.junit.Before;
import org.junit.Test;

/**
 * Tests whether or not the player loses a life from stepping on a river tile.
 */

public class GoalTileTest {

    @Test
    public void stepGoalTile() {
        Player player = new Player("Sudeep", DifficultyLevel.EASY);
        player.setScore(0);
        GoalTile goalTile = new GoalTile(ApplicationProvider.getApplicationContext());
        if (goalTile.step(player) == goalTile) {
            assertEquals(100, player.getScore());
        }
    }

}