package com.example.flappy_street;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class PlayerBoundaryTest {

    /**
     * Tests if a border keeps the player from moving infinitely.
     */
    @Test
    public void bottomBorder() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            float oY = test.getPosY();
            while (true) {
                test.changePos(false, false, true, false);
                if (oY == test.getPosY()) {
                    break;
                } else {
                    oY = test.getPosY();
                }
            }
            assertEquals(oY, test.getPosY(), 0);
        }
    }

    @Test
    public void topBorder() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            float oY = test.getPosY();
            while (true) {
                test.changePos(true, false, false, false);
                if (oY == test.getPosY()) {
                    break;
                } else {
                    oY = test.getPosY();
                }
            }
            assertEquals(oY, test.getPosY(), 0);
        }
    }

    @Test
    public void leftBorder() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            float oX = test.getPosY();
            while (true) {
                test.changePos(false, true, false, false);
                if (oX == test.getPosX()) {
                    break;
                } else {
                    oX = test.getPosX();
                }
            }
            assertEquals(oX, test.getPosX(), 0);
        }
    }

    @Test
    public void rightBorder() {
        try (ActivityController<GameScreen> controller =
                     Robolectric.buildActivity(GameScreen.class)) {
            controller.setup();
            GameScreen test = controller.get();
            float oX = test.getPosX();
            while (true) {
                test.changePos(false, false, false, true);
                if (oX == test.getPosX()) {
                    break;
                } else {
                    oX = test.getPosX();
                }
            }
            assertEquals(oX, test.getPosX(), 0);
        }
    }
}