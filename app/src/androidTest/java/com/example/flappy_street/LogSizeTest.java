package com.example.flappy_street;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.obstacles.river.BigPlatform;
import com.example.flappy_street.obstacles.river.SmallPlatform;

import org.junit.Assert;
import org.junit.Test;

public class LogSizeTest {
    @Test
    public void differentSizes() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        BigPlatform longLog = new BigPlatform(ApplicationProvider.getApplicationContext());
        SmallPlatform smallLog = new SmallPlatform(ApplicationProvider.getApplicationContext());

        GameLevel level = new GameLevel(context);
        longLog.setGameLevel(level);
        smallLog.setGameLevel(level);
        int beforePosLong = longLog.getXPos();
        int beforePosSmall = smallLog.getXPos();
        longLog.setYPos(2);
        smallLog.setYPos(2);
        for (int i = 0; i < 2500; i++) {
            longLog.move();
            smallLog.move();
        }
        int afterPosLong = longLog.getXPos();
        int afterPosSmall = smallLog.getXPos();

        Assert.assertTrue(afterPosLong > beforePosLong);
        Assert.assertTrue(afterPosSmall > beforePosSmall);
    }
}
