package com.example.flappy_street;

import static org.junit.Assert.assertNotEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.obstacles.Car;
import com.example.flappy_street.obstacles.Semi;
import com.example.flappy_street.obstacles.Truck;
import com.example.flappy_street.obstacles.Vehicle;

import org.junit.Test;

public class VehicleMovementSpeedTest {
    /**
     * Ensure each vehicle moves at a different speed.
     */
    @Test
    public void testMovementSpeed() {
        Vehicle car = new Car(ApplicationProvider.getApplicationContext());
        Vehicle truck = new Truck(ApplicationProvider.getApplicationContext());
        Vehicle semi = new Semi(ApplicationProvider.getApplicationContext());

        for (int i = 0; i < 1000; i++) { //arbitrary long number
            car.move();
            truck.move();
            semi.move();
        }

        assertNotEquals(car.getX(), truck.getX());
        assertNotEquals(car.getX(), semi.getX());
        assertNotEquals(truck.getX(), semi.getX());
    }
}
