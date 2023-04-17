package com.example.flappy_street.obstacles.vehicle;

import android.content.Context;
import android.util.Log;

import com.example.flappy_street.game.Player;
import com.example.flappy_street.obstacles.Obstacle;

public abstract class Vehicle extends Obstacle {

    protected int stepCount;
    protected static final float FUDGE_FACTOR = 30;

    /**
     * Create a new vehicle.
     * Subclasses should add a starting x position and add an image to represent it.
     * @param context The context this vehicle was created in
     */
    public Vehicle(Context context) {
        super(context);
        Log.i("INIT", "created vehicle");
    }

    /**
     * Check if the car collides with a given position.
     * @param player the player to check collisions with
     * @return true if the object collides, false otherwise
     */
    @Override
    public boolean collidesWith(Player player) {
        if (player.getX() == this.getX() && player.getY() == this.getY()) {
            return true; //early break condition for testing
        }
        boolean matchesLeftSideX = player.getX() >= this.getX() + FUDGE_FACTOR
                           && player.getX() < this.getX() + this.getWidth() - FUDGE_FACTOR;
        float playerRight = player.getX() + player.getWidth();
        boolean matchesRightSideX = playerRight >= this.getX() + FUDGE_FACTOR
                && playerRight < this.getX() + this.getWidth() - FUDGE_FACTOR;
        boolean matchesY = player.getY() >= realY
                           && player.getY() < realY + this.getHeight(); //don't care about bottom
        if ((matchesLeftSideX || matchesRightSideX) && matchesY) {
            player.die();
            return true;
        }
        return false;
    }

}
