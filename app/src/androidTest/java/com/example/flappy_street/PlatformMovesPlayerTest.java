package com.example.flappy_street;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.obstacles.river.Platform;
import com.example.flappy_street.obstacles.river.SmallPlatform;

import org.junit.Test;

public class PlatformMovesPlayerTest {

    @Test
    public void platformMovesPlayer(){
        Context ctx = ApplicationProvider.getApplicationContext();
        Player p = new Player(ctx);
        p.init(0, "a", DifficultyLevel.EASY);
        Platform v = new SmallPlatform(ctx);
        GameLevel level = new GameLevel(ctx);
        p.setGameLevel(level);
        v.setGameLevel(level);
        v.setYPos(2);
        p.setY(v.getY());
        p.setX(v.getX());
        p.setMaxWidth(0);
        float oldX = p.getX();
        for (int i = 0; i < 10 && v.collidesWith(p); i++) {
            v.move();
            assertTrue(v.collidesWith(p));
        }
        assertNotEquals(oldX, p.getX());
    }
}
