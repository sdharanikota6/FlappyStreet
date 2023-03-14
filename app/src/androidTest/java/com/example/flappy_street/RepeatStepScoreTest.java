package com.example.flappy_street;

import static org.junit.Assert.*;


import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.GoalTile;
import com.example.flappy_street.tiles.RiverTile;
import com.example.flappy_street.tiles.RoadTile;
import com.example.flappy_street.tiles.SafeTile;

import org.junit.Test;

public class RepeatStepScoreTest {

    /**
     * Tests to make sure score does not increment by stepping on the same tile.
     */
    @Test
    public void roadStep() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldScore = player.getScore();
        RoadTile roadTile = new RoadTile(ApplicationProvider.getApplicationContext());
        roadTile.step(player);
        float newScore = player.getScore();
        roadTile.step(player);
        assertNotEquals(oldScore,newScore);
        float newScore2 = player.getScore();
        assertEquals(newScore, newScore2, 0);
    }
    @Test
    public void riverStep() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldScore = player.getScore();
        RiverTile riverTile = new RiverTile(ApplicationProvider.getApplicationContext());
        riverTile.step(player);
        float newScore = player.getScore();
        riverTile.step(player);
        assertNotEquals(oldScore,newScore);
        float newScore2 = player.getScore();
        assertEquals(newScore, newScore2, 0);
    }

    /**
     * Goal step increments points by 100 each time it is stepped on without a flag
     * to check due to the player being forced to a new level when stepped on.
     * This means theres no need to add a flag to check if stepped already.
     */
    @Test
    public void goalStep() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldScore = player.getScore();
        GoalTile goalTile = new GoalTile(ApplicationProvider.getApplicationContext());
        goalTile.step(player);
        float newScore = player.getScore();
        goalTile.step(player);
        assertNotEquals(oldScore,newScore);
        float newScore2 = player.getScore();
        assertNotEquals(newScore, newScore2);
    }

    /**
     * Stepping on safe should not increment points either way
     */
    @Test
    public void safeStep() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "a", DifficultyLevel.EASY);
        float oldScore = player.getScore();
        SafeTile safeTile = new SafeTile(ApplicationProvider.getApplicationContext());
        safeTile.step(player);
        float newScore = player.getScore();
        assertEquals(oldScore, newScore, 0);
    }
}
