package com.example.flappy_street;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;
import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.obstacles.Truck;
import org.junit.Test;

/**
 * test to see if the player's score resets to 0 once they are hit by a vehicle
 */
public class TruckCollisionScoreResetTest {
    @Test
    public void checkScoreReset() {
        Player testplayer = new Player(ApplicationProvider.getApplicationContext());
        testplayer.init(0, "des", DifficultyLevel.EASY);
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Truck truck = new Truck(context);
        int afterscore = testplayer.getScore();
        if (truck.collidesWith(testplayer) == true) {
            assertEquals(afterscore, 0);
        }
    }
}
