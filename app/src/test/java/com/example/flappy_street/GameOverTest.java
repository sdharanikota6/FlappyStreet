package com.example.flappy_street;

import static org.junit.Assert.*;
import static org.robolectric.Shadows.shadowOf;

import android.widget.Button;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
public class GameOverTest {

    /**
     * Tests if the highScore between the gameScreen and
     * resultScreen stays the same after a gameOver.
     */
    @Test
    public void gameOverHighScoreTest() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            test.gameOver();
            ActivityController<ResultActivity> testing =
                    Robolectric.buildActivity(ResultActivity.class);
            testing.setup();
            ResultActivity results = testing.get();
            assertEquals(test.getHighScore(), results.getHighScore());
        }
    }
}