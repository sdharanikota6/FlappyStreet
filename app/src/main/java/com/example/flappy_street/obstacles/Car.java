package com.example.flappy_street.obstacles;

import android.content.Context;

import com.example.flappy_street.R;

public class Car extends Vehicle {

    public Car(Context context) {
        super(context);
        this.setImageResource(R.drawable.car);
        this.size = 1;
    }

    @Override
    public void move() {
        stepCount = (stepCount + 1) % STEPS_PER_TILE;
        if (stepCount == 0) {
            this.setXPos(this.getXPos() + 1);
        }
        float stepSize = this.getX() + (tileSize / STEPS_PER_TILE);
        this.setX(stepSize % rightBound);
    }
}
