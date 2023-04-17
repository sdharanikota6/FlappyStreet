package com.example.flappy_street.obstacles.river;

import android.content.Context;

import com.example.flappy_street.R;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.RiverTile;

public class SmallPlatform extends Platform {

    public SmallPlatform(Context ctx) {
        super(ctx);
        this.size = 2;
        this.speed = 30;
        this.setImageResource(R.drawable.short_log);
    }

    @Override
    public void move() {
        stepCount = (stepCount + 1) % speed;
        if (stepCount == 0) {
            if (xPos < 7) {
                ((RiverTile) level.getTile(yPos, xPos)).uncover();
            }
            this.setXPos(this.getXPos() + 1);
            for (int i = 0; i < size; i++) {
                if (xPos + i > 6) {
                    break;
                }
                ((RiverTile) level.getTile(yPos, xPos + i - 1)).cover(); // I don't get it
            }
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
            if (newX > rightBound - player.getWidth()) {
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
