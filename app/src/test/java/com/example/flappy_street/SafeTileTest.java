package com.example.flappy_street;
import static org.junit.Assert.assertEquals;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.SafeTile;

import org.junit.Before;
import org.junit.Test;


public class SafeTileTest {

    @Test
    public void stepOnSafeTile() {
        SafeTile safeTile = new SafeTile();
        Player testPlayer = new Player("Robert", DifficultyLevel.EASY);
        if (safeTile.step(testPlayer) == safeTile) {
            assertEquals(5, testPlayer.getLives());
        }
    }

}
