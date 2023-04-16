package com.example.flappy_street.obstacles.river;

import android.content.Context;

import com.example.flappy_street.R;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RiverTile;

public class BigPlatform extends Platform {

    public BigPlatform(Context ctx) {
        super(ctx);
        this.size = 3;
        this.speed = 25;
        this.setImageResource(R.drawable.long_log);
    }

    @Override
    public void move() {
        stepCount = (stepCount + 1) % speed;
        if (stepCount == 0) {
            if (xPos + size < 7) {
                ((RiverTile) level.getTile(yPos, xPos + size)).uncover();
            }
            this.setXPos(this.getXPos() - 1);
            for (int i = 0; i < size; i++) {
                if (!(xPos + i > 6 || xPos + i - 1 < 0)) {
                    ((RiverTile) level.getTile(yPos, xPos + i - 1)).cover();
                }
            }
        }
        float newPos = this.getX() - (tileSize / speed);
        if (newPos < -getWidth()) {
            this.setX(rightBound);
            this.setXPos(6);
        } else {
            this.setX(newPos);
        }
    }

    @Override
    public boolean collidesWith(Player player) {
        if (super.collidesWith(player)) {
            float newX = player.getX() - (tileSize / speed);
            if (newX < 0) {
                player.die();
            } else {
                player.setX(newX);
                player.updateXPos();
            }
            return true;
        }
        return false;
    }
}
