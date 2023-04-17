
import static org.junit.Assert.assertEquals;

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
        BigPlatform longLog = new BigPlatform();
        SmallPlatform smallLog = new SmallPlatform();
        assertNotEquals(longLog.getSpeed(), smallLog.getSpeed());
    }
}