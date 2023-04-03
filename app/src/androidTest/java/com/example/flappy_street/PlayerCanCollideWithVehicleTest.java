package com.example.flappy_street;

import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.obstacles.Car;
import com.example.flappy_street.obstacles.Vehicle;
import com.example.flappy_street.obstacles.VehicleRow;

import org.junit.Test;

public class PlayerCanCollideWithVehicleTest {

    @Test
    public void collisionTest() {
        Context ctx = ApplicationProvider.getApplicationContext();
        Player p = new Player(ctx);
        p.init(0, "a", DifficultyLevel.EASY);
        Vehicle v = new Car(ctx);
        p.setY(v.getY());
        p.setX(v.getX());
        assertTrue(v.collidesWith(p));
    }
}
