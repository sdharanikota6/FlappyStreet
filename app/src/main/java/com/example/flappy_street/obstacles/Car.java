package com.example.flappy_street.obstacles;

import android.content.Context;

public class Car extends Vehicle {

    public Car(Context context) {
        super(context);
    }

    @Override
    public void move() {
        this.setXPos(this.getXPos() + 1);
    }
}
