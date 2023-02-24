package com.example.flappy_street;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.util.AttributeSet;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;


import org.junit.Test;

public class PlayerCanMoveUnitTest{
    @Test
    public void canMoveLeft() {
        /* Does not compile because I don't know how to pass context and attributes yet */
//        Player player = new Player("test", DifficultyLevel.EASY);
//        player.setxPos(10); // Need to auto set in Player constructor I would think
//        player.setyPos(10); // Need to auto set in Player constructor I would think
//        Context context =  ApplicationProvider.getApplicationContext();
//        GameLevel gameLevel = new GameLevel(context, null);
//        player.setGameLevel(gameLevel);
//        int oldPos = player.getxPos();
//        player.moveLeft();
//        int newPos = player.getxPos();
//        assertTrue(newPos < oldPos);
    }
}
