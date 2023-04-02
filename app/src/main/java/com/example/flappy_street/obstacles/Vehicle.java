package com.example.flappy_street.obstacles;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.tiles.TileAdapter;

public abstract class Vehicle extends AppCompatImageView {

    protected int xPos;
    protected int yPos;
    protected int size;
    protected int stepCount;
    protected final float tileSize;
    protected final float rightBound;
    protected static final float LEFT_BOUND = 0;

    /**
     * Create a new vehicle.
     * Subclasses should add a starting x position and add an image to represent it.
     * @param context The context this vehicle was created in
     */
    public Vehicle(Context context) {
        super(context);
        Point size = TileAdapter.getSize();
        tileSize = (float) size.x / GameLevel.NUM_COLUMNS;
        rightBound = size.x;
        Log.i("INIT", "created vehicle");
    }

    public int getXPos() {
        return xPos;
    }

    public void setXPos(int newPos) {
        this.xPos = newPos;
    }

    public int getYPos() {
        return yPos;
    }

    public int getSize() {
        return size;
    }

    /**
     * Move the vehicle in a direction. Implementation should handle backend movement,
     * specify the direction, and collision detection.
     */
    public abstract void move();

    /**
     * Check if the car collides with a given position.
     * @param player the player to check collisions with
     * @return true if the object collides, false otherwise
     */
    public boolean collidesWith(Player player) {
        boolean matchesX = player.getX() >= this.getX()
                           && player.getX() < this.getX() + this.getWidth();
        boolean matchesY = player.getY() <= this.getY()
                           && player.getY() > this.getY() - this.getHeight();
        return matchesX && matchesY;
    }

}
