package com.example.flappy_street.obstacles;

import android.content.Context;
import android.view.Display;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.tiles.TileAdapter;

public abstract class Vehicle extends AppCompatImageView {

    protected int xPos;
    protected int yPos;
    protected int size;
    protected final float STEP_SIZE;

    /**
     * Create a new vehicle.
     * Subclasses should add a starting x position and add an image to represent it.
     * @param context The context this vehicle was created in
     */
    public Vehicle(Context context) {
        super(context);
        STEP_SIZE = (float) TileAdapter.getSize().x / GameLevel.NUM_COLUMNS;
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
     * @param collisionPos the position to check collision with
     * @return true if the object collides, false otherwise
     */
    public boolean collidesWith(int collisionPos) {
        return collisionPos >= xPos && collisionPos < xPos + size;
    }

}
