package com.example.flappy_street.obstacles.river;

import android.content.Context;

import com.example.flappy_street.game.Player;
import com.example.flappy_street.obstacles.Obstacle;

public abstract class Platform extends Obstacle {


    protected int speed;
    protected int stepCount;
    protected static final float LEFT_BOUND = 0;
    private static final int FUDGE_FACTOR = 30;



    public Platform(Context context) {
        super(context);
    }

    /**
     * Move the player in a direction. Implementation should handle backend movement,
     * specify the direction, and collision detection.
     */
    public abstract void move();

    /**
     * Check if the platform collides with a given player.
     * @param player the player to check collisions with
     * @return true if the object collides, false otherwise
     */
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
        return (matchesLeftSideX || matchesRightSideX) && matchesY;
    }
}
