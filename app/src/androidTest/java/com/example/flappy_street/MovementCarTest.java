package com.example.flappy_street;
import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import static org.junit.Assert.assertEquals;

import com.example.flappy_street.obstacles.vehicle.Car;

import org.junit.Test;

public class MovementCarTest {
    @Test
    public void yPosStaysTheSame() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Car c = new Car(context);
        int currPos = c.getYPos();
        c.move();
        assertEquals(currPos, c.getYPos());
    }
}