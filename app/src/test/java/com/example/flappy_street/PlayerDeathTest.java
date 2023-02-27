package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

import org.junit.Test;

public class PlayerDeathTest {

    @Test
    public void deathDecreasesLives() {
        Player easy = new Player("a", DifficultyLevel.EASY);
        Player medium = new Player("b", DifficultyLevel.MEDIUM);
        Player hard = new Player("c", DifficultyLevel.HARD);

        assertEquals(easy.getLives(), 5);
        assertEquals(medium.getLives(), 3);
        assertEquals(hard.getLives(), 1);

        while(easy.getLives() > 0) {
            easy.die();
        }
        assertEquals(easy.getLives(), 0);

        while(medium.getLives() > 0) {
            medium.die();
        }
        assertEquals(medium.getLives(), 0);

        while(hard.getLives() > 0) {
            hard.die();
        }
        assertEquals(hard.getLives(), 0);
    }
}
