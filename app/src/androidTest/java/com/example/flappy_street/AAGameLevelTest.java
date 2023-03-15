package com.example.flappy_street;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.example.flappy_street.levels.GameLevel;

import org.junit.Test;

public class AAGameLevelTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void ensureCorrectSize() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        GameLevel level = new GameLevel(context);
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                count++;
                assertNotNull(level.getTile(i,j));
            }
        }
        assertEquals(count, 70);

        level.getTile(11,0);
    }
}
