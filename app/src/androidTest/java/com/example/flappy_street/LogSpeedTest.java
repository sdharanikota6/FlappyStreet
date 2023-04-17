
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.obstacles.river.BigPlatform;
import com.example.flappy_street.obstacles.river.SmallPlatform;
import com.example.flappy_street.tiles.RiverTile;

import org.junit.Test;

public class LogSpeedTest {
    @Test
    public void logSpeeds() {
        BigPlatform longLog = new BigPlatform(ApplicationProvider.getApplicationContext());
        SmallPlatform smallLog = new SmallPlatform(ApplicationProvider.getApplicationContext());

        for (int i = 0; i < 1000; i++) {
            longLog.move();
            smallLog.move();
        }
        assertNotEquals(longLog.getY(), smallLog.getY());
    }
}