package com.example.flappy_street.obstacles;

import android.content.Context;

import com.example.flappy_street.R;
import com.example.flappy_street.levels.GameLevel;

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
            this.setXPos((this.getXPos() - 1) % GameLevel.NUM_COLUMNS);
        }
        float newPos = this.getX() - (tileSize / STEPS_PER_TILE);
        if (newPos % rightBound > newPos) {
            this.setX(rightBound + this.getSize());
        } else {
            this.setX(newPos);
        }
    }
}
