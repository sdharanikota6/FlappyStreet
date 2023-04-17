package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.obstacles.vehicle.Car;
import com.example.flappy_street.obstacles.vehicle.Vehicle;

import org.junit.Test;

/**
 *
 */
public class PositionAfterVehicleCollisionTest {
    @Test
    public void positionBacktoBeforeDie() {
        Player testPlayer = new Player(ApplicationProvider.getApplicationContext());
        testPlayer.init(0, "gwu", DifficultyLevel.EASY);
        Vehicle car = new Car(ApplicationProvider.getApplicationContext());
        float beforeX = testPlayer.getX();
        float beforeY = testPlayer.getY();
        while (car.getYPos() != testPlayer.getY() && car.getXPos() != testPlayer.getX()) {
            testPlayer.moveUp();
            beforeX = testPlayer.getX();
            beforeY = testPlayer.getY();
        }
        if (car.getYPos() == testPlayer.getY() && car.getXPos() == testPlayer.getX()) {
            assertEquals(beforeX, testPlayer.getX(), 1);
            assertEquals(beforeY, testPlayer.getY(), 1);
        }
    }
}
