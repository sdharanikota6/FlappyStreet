package com.example.flappy_street;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import static org.junit.Assert.assertEquals;
import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.obstacles.vehicle.Semi;
import org.junit.Test;

public class SemiCollisionScoreResetTest {
    @Test
    public void checkScoreResetAfterCollision() {
        Player player = new Player(ApplicationProvider.getApplicationContext());
        player.init(0, "SD", DifficultyLevel.EASY);
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Semi semi = new Semi(context);
        int score = player.getScore();
        if (semi.collidesWith(player) == true) {
            assertEquals(score, 0);
        }
    }
}
