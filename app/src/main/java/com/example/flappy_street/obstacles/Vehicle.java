package com.example.flappy_street.obstacles;

import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;

public abstract class Vehicle extends AppCompatImageView {

    private int xPos;
    private int yPos;
    private int size;

    /**
     * Create a new vehicle.
     * Subclasses should add a starting x position and add an image to represent it.
     * @param context The context this vehicle was created in
     */
    public Vehicle(Context context) {
        super(context);
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
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
}
