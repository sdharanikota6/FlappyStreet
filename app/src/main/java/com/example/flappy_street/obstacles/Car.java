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
        this.setXPos(this.getXPos() + 1);
        this.setX((this.getX() + STEP_SIZE) % RIGHT_BOUND);
    }
}
