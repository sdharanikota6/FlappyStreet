package com.example.flappy_street;

import static org.junit.Assert.*;

import android.widget.Button;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class ConfigScreenPassedHighScoreTest {

    @Test
    public void configScreenHighScoreTest() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            test.gameOver();
            ActivityController<ResultActivity> testing =
                    Robolectric.buildActivity(ResultActivity.class);
            testing.setup();
            ResultActivity results = testing.get();
            results.configButton();
            ActivityController<ConfigScreen> testing2 =
                    Robolectric.buildActivity(ConfigScreen.class);
            testing2.setup();
            ConfigScreen config = testing2.get();
            config.startGameScreen();
            controller.restart();
            assertEquals(test.getHighScore(), config.getHighScore());
        }
    }
}
