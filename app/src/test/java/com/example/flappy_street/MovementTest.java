package com.example.flappy_street;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class MovementTest {

    /**
     * Tests if the player moves based on directionals.
     */
    @Test
    public void movementTestUp() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            float oY = test.getPosY();
            test.changePos(true, false, false, false);
            float nY = test.getPosY();
            assertNotEquals(oY, nY);
        }
    }
    @Test
    public void movementTestDown() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            test.changePos(true, false, false, false);
            float oY = test.getPosY();
            test.changePos(false, false, true, false);
            float nY = test.getPosY();
            assertNotEquals(oY, nY);
        }
    }
    @Test
    public void movementTestLeft() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            float oX = test.getPosX();
            test.changePos(false, true, false, false);
            float nX = test.getPosX();
            assertNotEquals(oX, nX);
        }
    }
    @Test
    public void movementTestRight() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            float oX = test.getPosX();
            test.changePos(false, false, false, true);
            float nX = test.getPosX();
            assertNotEquals(oX, nX);
        }
    }
}