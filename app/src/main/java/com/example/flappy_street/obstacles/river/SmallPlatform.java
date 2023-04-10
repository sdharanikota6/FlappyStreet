package com.example.flappy_street.obstacles.river;

import android.content.Context;

public class SmallPlatform extends Platform {

    public SmallPlatform(Context ctx) {
        super(ctx);
        this.size = 1;
        this.speed = 15;
    }

    @Override
    public void move() {
        stepCount = (stepCount + 1) % speed;
        if (stepCount == 0) {
            this.setXPos(this.getXPos() + 1);
        }
        float newPos = this.getX() + (tileSize / speed);
        if (newPos % rightBound < newPos) {
            this.setX(-this.getWidth());
            this.setXPos(0);
        } else {
            this.setX(newPos);
        }
    }

}
