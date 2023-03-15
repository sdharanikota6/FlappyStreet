package com.example.flappy_street;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;

import com.example.flappy_street.obstacles.Car;
import com.example.flappy_street.obstacles.Semi;
import com.example.flappy_street.obstacles.Truck;

import org.junit.Assert;
import org.junit.Test;
public class AlternatingMovementTest {
    @Test
    public void ensureAlternatingMovement() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Truck truck = new Truck(context);
        int beforePosTruck = truck.getXPos();
        Semi semi = new Semi(context);
        int beforePosSemi = semi.getXPos();
        Car car = new Car(context);
        int beforePosCar = car.getXPos();

        truck.move();
        semi.move();
        car.move();

        int afterPosTruck = truck.getXPos();
        int afterPosSemi = semi.getXPos();
        int afterPosCar = car.getXPos();





        Assert.assertTrue(afterPosTruck > beforePosTruck);
        Assert.assertTrue(afterPosSemi == beforePosSemi);
        Assert.assertTrue(afterPosCar == beforePosCar);

    }
}
