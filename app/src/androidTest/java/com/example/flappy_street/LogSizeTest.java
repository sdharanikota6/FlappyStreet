package com.example.flappy_street;

import static org.junit.Assert.assertNotEquals;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.flappy_street.obstacles.Car;
import com.example.flappy_street.obstacles.Semi;
import com.example.flappy_street.obstacles.Truck;
import com.example.flappy_street.obstacles.Vehicle;

import org.junit.Assert;
import org.junit.Test;

public class LogSizeTest {
    @Test
    public void differentSizes() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        BigPlatform longLog = new BigPlatform(ApplicationProvider.getApplicationContext());
        SmallPlatform smallLog = new SmallPlatform(ApplicationProvider.getApplicationContext());
        int beforePosLong = longLog.getX();
        int beforePosSmall = smallLog.getX();

        for (int i = 0; i < 2500; i++) {
            longLog.move();
            smallLog.move();
        }
        int afterPosLong = longLog.getX();
        int afterPosSmall = smallLog.getX();;

        Assert.assertTrue(afterPosLong > beforePosLong);
        Assert.assertTrue(afterPosSmall > beforePosSmall);
    }
}
