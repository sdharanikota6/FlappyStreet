package com.example.flappy_street.obstacles;

import android.content.Context;

import com.example.flappy_street.R;
import com.example.flappy_street.levels.GameLevel;

public class Car extends Vehicle {

    private static final int STEPS_PER_TILE = 25;

    public Car(Context context) {
        super(context);
        this.setImageResource(R.drawable.car);
        this.size = 1;
    }

    @Override
    public void move() {
        stepCount = (stepCount + 1) % STEPS_PER_TILE;
        if (stepCount == 0) {
            this.setXPos((this.getXPos() + 1) % GameLevel.NUM_COLUMNS);
        }
        float newPos = this.getX() + (tileSize / STEPS_PER_TILE);
        if (newPos % rightBound < newPos) {
            this.setX(- this.getSize());
        } else {
            this.setX(newPos);
        }
        
    }
}
