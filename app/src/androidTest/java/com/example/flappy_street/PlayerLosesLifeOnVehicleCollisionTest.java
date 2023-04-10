package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.obstacles.vehicle.Car;
import com.example.flappy_street.obstacles.vehicle.VehicleRow;

import org.junit.Test;

public class PlayerLosesLifeOnVehicleCollisionTest {

    @Test
    public void playerCollision() {
        Context ctx = ApplicationProvider.getApplicationContext();
        Player p = new Player(ctx);
        p.init(0, "a", DifficultyLevel.EASY);
        VehicleRow v = new VehicleRow(ctx).init(Car.class, 4, 0);
        assertEquals(p.getLives(), 5);
        p.setY(v.getY());
        p.setX(v.getX());
        v.checkCollision(p);
        assertEquals(p.getLives(), 4);
    }
}
