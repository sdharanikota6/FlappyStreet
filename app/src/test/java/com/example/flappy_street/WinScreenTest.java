package com.example.flappy_street;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

import android.content.Intent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

@RunWith(RobolectricTestRunner.class)
public class WinScreenTest {


    @Test
    public void GameOverMovesToResultScreen() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            test.gameOver();
            ShadowActivity shadowActivity = shadowOf(test);
            Intent startedIntent = shadowActivity.getNextStartedActivity();
            ShadowIntent shadowIntent = shadowOf(startedIntent);
            assertEquals(shadowIntent.getIntentClass().getName(), ResultActivity.class.getName());
        }
    }
}
