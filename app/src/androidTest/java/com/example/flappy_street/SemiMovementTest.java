package com.example.flappy_street;
import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import static org.junit.Assert.assertEquals;

import com.example.flappy_street.obstacles.Semi;

import org.junit.Test;

public class SemiMovementTest {
    @Test
    public void yPosStaysTheSame() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Semi s = new Semi(context);
        int currPos = s.getYPos();
        s.move();
        assertEquals(currPos, s.getYPos());
    }
}