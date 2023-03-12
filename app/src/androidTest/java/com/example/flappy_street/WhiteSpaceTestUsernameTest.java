package com.example.flappy_street;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

import org.junit.Test;

/**
 * Tests the input for a valid username.
 */

public class WhiteSpaceTestUsernameTest {
    @Test (expected = IllegalArgumentException.class)
    public void inputEmpty() {
        String name = "";
        Player noNamePlayer = new Player(ApplicationProvider.getApplicationContext());
        noNamePlayer.init(1, name, DifficultyLevel.EASY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void inputSpace() {
        String name = "    ";
        Player noNamePlayer = new Player(ApplicationProvider.getApplicationContext());
        noNamePlayer.init(1, name, DifficultyLevel.EASY);
    }
}