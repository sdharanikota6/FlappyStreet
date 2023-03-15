package com.example.flappy_street;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.flappy_street.obstacles.Car;
import com.example.flappy_street.obstacles.Semi;
import com.example.flappy_street.obstacles.Truck;

import org.junit.Assert;
import org.junit.Test;
public class AlternatingMovementTest {
    @Test
    public void ensureAlternatingMovement() {
        Context context = ApplicationProvider.getApplicationContext();
        Truck truck = new Truck(context);
        truck.setXPos(6);
        int beforePosTruck = truck.getXPos();
        Semi semi = new Semi(context);
        int beforePosSemi = semi.getXPos();
        Car car = new Car(context);
        int beforePosCar = car.getXPos();

        for (int i = 0; i < 35; i++) {
            truck.move();
        }
        for (int i = 0; i < 35; i++) {
            semi.move();
        }
        for (int i = 0; i < 25; i++) {
            car.move();
        }

        int afterPosTruck = truck.getXPos();
        int afterPosSemi = semi.getXPos();
        int afterPosCar = car.getXPos();

        Assert.assertTrue(afterPosTruck < beforePosTruck);
        Assert.assertTrue(afterPosSemi > beforePosSemi);
        Assert.assertTrue(afterPosCar > beforePosCar);

    }
}
