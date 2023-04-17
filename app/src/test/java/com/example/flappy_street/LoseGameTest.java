package com.example.flappy_street;

import static org.junit.Assert.assertEquals;
import static org.robolectric.Shadows.shadowOf;

import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
public class LoseGameTest {

    @Test
    public void  dyingHasDeathEndScreenMessage() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            Button button = (Button) test.findViewById(R.id.moveUP);
            button.performClick();
            test.gameOver();
            ShadowActivity shadowActivity = shadowOf(test);
            ActivityController<ResultActivity> testing =
                    Robolectric.buildActivity(ResultActivity.class);
            testing.create();
            ResultActivity results = testing.get();
            TextView text = results.findViewById(R.id.endScreenTitle);
            assertEquals("You LOSE", text.getText().toString());
        }
    }
}