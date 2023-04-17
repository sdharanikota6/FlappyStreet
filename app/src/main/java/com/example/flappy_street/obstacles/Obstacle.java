package com.example.flappy_street.obstacles;

import android.content.Context;
import android.graphics.Point;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.tiles.TileAdapter;

public abstract class Obstacle extends AppCompatImageView {
    protected static final float LEFT_BOUND = 0;
    protected final float rightBound;
    protected final float tileSize;
    protected GameLevel level;
    protected int xPos;
    protected int yPos;
    protected int size;
    /**
     * Actual Y is not stored by default, must manually find
     */
    protected float realY;

    public Obstacle(Context context) {
        super(context);
        Point size = TileAdapter.getSize();
        tileSize = (float) size.x / GameLevel.NUM_COLUMNS;
        rightBound = size.x;
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int newPos) {
        this.xPos = newPos;
    }

    public void setRealY(float y) {
        this.realY = y;
    }

    public void setYPos(int y) {
        this.yPos = y;
    }

    public int getYPos() {
        return yPos;
    }

    public int getSize() {
        return size;
    }

    public void setGameLevel(GameLevel level) {
        this.level = level;
    }

    /**
     * Move the vehicle in a direction. Implementation should handle backend movement,
     * specify the direction, and collision detection.
     */
    public abstract void move();

    public abstract boolean collidesWith(Player player);
}
