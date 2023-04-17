package com.example.flappy_street;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.obstacles.river.BigPlatform;
import com.example.flappy_street.obstacles.river.SmallPlatform;

import org.junit.Test;

public class LogSpeedTest {
    @Test
    public void logSpeeds() {
        Context ctx = ApplicationProvider.getApplicationContext();
        BigPlatform longLog = new BigPlatform(ApplicationProvider.getApplicationContext());
        SmallPlatform smallLog = new SmallPlatform(ApplicationProvider.getApplicationContext());
        GameLevel level = new GameLevel(ctx);
        longLog.setGameLevel(level);
        smallLog.setGameLevel(level);
        longLog.setYPos(2);
        smallLog.setYPos(2);
        for (int i = 0; i < 1000; i++) {
            longLog.move();
            smallLog.move();
        }
        assertEquals(longLog.getYPos(), 2);
        assertEquals(smallLog.getYPos(), 2);
    }
}