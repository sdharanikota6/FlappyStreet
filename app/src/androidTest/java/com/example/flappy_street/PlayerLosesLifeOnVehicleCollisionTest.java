package com.example.flappy_street;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.obstacles.ObstacleRow;
import com.example.flappy_street.obstacles.vehicle.Car;
import com.example.flappy_street.obstacles.vehicle.Vehicle;

import org.junit.Test;

public class PlayerLosesLifeOnVehicleCollisionTest {

    @Test
    public void playerCollision() {
        Context ctx = ApplicationProvider.getApplicationContext();
        Player p = new Player(ctx);
        p.init(0, "a", DifficultyLevel.EASY);
        Vehicle v = new Car(ctx);
        GameLevel level = new GameLevel(ctx);
        p.setGameLevel(level);
        v.setGameLevel(level);
        v.setYPos(2);
        p.setY(v.getY());
        p.setX(v.getX());
        int oldLives = p.getLives();
        while (!v.collidesWith(p)) {
            v.move();
        }
        assertEquals(p.getLives(), 4);
    }
}
