package com.example.flappy_street.obstacles.river;

import android.content.Context;

import com.example.flappy_street.game.Player;

public class SmallPlatform extends Platform {

    public SmallPlatform(Context ctx) {
        super(ctx);
        this.size = 2;
        this.speed = 30;
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

    @Override
    public boolean collidesWith(Player player) {
        if (super.collidesWith(player)) {
            float newX = player.getX() + (tileSize / speed);
            if (newX > rightBound) {
                player.die();
            }
            player.setX(newX);
            return true;
        }
        return false;
    }
}
