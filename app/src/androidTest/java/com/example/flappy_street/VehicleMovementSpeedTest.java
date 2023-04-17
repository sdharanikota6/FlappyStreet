package com.example.flappy_street;

import static org.junit.Assert.assertNotEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.obstacles.vehicle.Car;
import com.example.flappy_street.obstacles.vehicle.Semi;
import com.example.flappy_street.obstacles.vehicle.Truck;
import com.example.flappy_street.obstacles.vehicle.Vehicle;

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
