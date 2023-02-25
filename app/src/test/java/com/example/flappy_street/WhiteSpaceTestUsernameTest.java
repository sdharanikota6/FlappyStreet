package com.example.flappy_street;

import static org.junit.Assert.*;

import android.content.Intent;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

import org.junit.Test;

public class WhiteSpaceTestUsernameTest {
    @Test (expected = IllegalArgumentException.class)
    public void inputEmpty() {
        String name = "";
        Player noNamePlayer = new Player(name, DifficultyLevel.EASY);
    }

    @Test (expected = IllegalArgumentException.class)
    public void inputSpace() {
        String name = "    ";
        Player noNamePlayer = new Player(name, DifficultyLevel.EASY);
    }
}