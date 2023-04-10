package com.example.flappy_street.obstacles.vehicle;

import android.content.Context;

import com.example.flappy_street.R;
import com.example.flappy_street.obstacles.vehicle.Vehicle;

public class Truck extends Vehicle {

    private static final int STEPS_PER_TILE = 35;

    public Truck(Context context) {
        super(context);
        this.setImageResource(R.drawable.truck);
        this.size = 2;
    }

    @Override
    public void move() {
        stepCount = (stepCount + 1) % STEPS_PER_TILE;
        if (stepCount == 0) {
            this.setXPos(this.getXPos() - 1);
        }
        float newPos = this.getX() - (tileSize / STEPS_PER_TILE);
        if (newPos < (-getWidth())) {
            this.setX(rightBound);
            this.setXPos(6);
        } else {
            this.setX(newPos);
        }
    }
}
