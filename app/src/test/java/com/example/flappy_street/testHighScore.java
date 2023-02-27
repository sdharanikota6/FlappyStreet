package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

import org.junit.Test;

public class testHighScore {

    public void highScore() {
        Player player = new Player("Sudeep", DifficultyLevel.EASY);
        player.win();
        assertEquals(100, player.getHighScore());
    }
}
