package com.example.flappy_street.obstacles.vehicle;

import android.content.Context;

import com.example.flappy_street.R;
import com.example.flappy_street.obstacles.vehicle.Vehicle;

public class Semi extends Vehicle {
    private static final int STEPS_PER_TILE = 50;

    public Semi(Context context) {
        super(context);
        this.setImageResource(R.drawable.semi);
        this.size = 3;
    }

    @Override
    public void move() {
        stepCount = (stepCount + 1) % STEPS_PER_TILE;
        if (stepCount == 0) {
            this.setXPos(this.getXPos() + 1);
        }
        float newPos = this.getX() + (tileSize / STEPS_PER_TILE);
        if (newPos % rightBound < newPos) {
            this.setX(LEFT_BOUND - this.getWidth());
            this.setXPos(0);
        } else {
            this.setX(newPos);
        }
    }
}
