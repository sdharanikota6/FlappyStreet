package com.example.flappy_street;

import org.junit.Test;

public class LogSizeTest {
    @Test
    public void differentSizes() {
        BigPlatform longLog = new BigPlatform();
        SmallPlatform smallLog = new SmallPlatform();
        assertNotEquals(longLog.getSize(), smallLog.getSize());
    }
}
