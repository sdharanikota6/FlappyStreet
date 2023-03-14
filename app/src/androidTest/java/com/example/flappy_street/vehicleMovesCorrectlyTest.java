package com.example.flappy_street;
import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class vehicleMovesCorrectlyTest {
    @Test
    public void yPosStaysTheSame() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Truck truck = new Truck(context);
        int currPos = truck.getYPos();
        truck.move();
        assertEquals(currPos, truck.getYPos());
    }
}
