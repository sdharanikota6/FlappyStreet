package com.example.flappy_street;

import static org.junit.Assert.*;

import android.widget.Button;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

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
            Button button = (Button) test.findViewById(R.id.moveUP);
            button.performClick();
            test.gameOver();
            ActivityController<ResultActivity> testing =
                    Robolectric.buildActivity(ResultActivity.class);
            testing.setup();
            ResultActivity results = testing.get();
            results.resetButton();
            assertEquals(test.getHighScore(), results.getHighScore());
        }
    }
}