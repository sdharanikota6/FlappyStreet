package com.example.flappy_street;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import androidx.test.core.app.ApplicationProvider;

import com.example.flappy_street.obstacles.vehicle.Car;
import com.example.flappy_street.obstacles.vehicle.Semi;
import com.example.flappy_street.obstacles.vehicle.Truck;
import com.example.flappy_street.obstacles.vehicle.Vehicle;

import org.junit.Test;

public class VehicleBackendMovementSpeedTest {

    /**
     * Ensure each vehicle moves at a certain speed.
     */
    @Test
    public void testMovementSpeed() {
        Vehicle car = new Car(ApplicationProvider.getApplicationContext());
        Vehicle truck = new Truck(ApplicationProvider.getApplicationContext());
        truck.setXPos(6); //weird fix for movement jank
        Vehicle semi = new Semi(ApplicationProvider.getApplicationContext());

        for (int i = 0; i < 25; i++) {
            car.move();
        }
        for (int i = 0; i < 35; i++) {
            truck.move();
        }
        for (int i = 0; i < 50; i++) {
            semi.move();
        }

        assertEquals(car.getXPos(), 1);
        assertEquals(truck.getXPos(), 5);
        assertEquals(semi.getXPos(), 1);
    }
}
