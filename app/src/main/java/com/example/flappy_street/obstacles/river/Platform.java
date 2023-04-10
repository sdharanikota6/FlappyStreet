package com.example.flappy_street.obstacles.river;

import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.R;
import com.example.flappy_street.game.Player;

public abstract class Platform extends AppCompatImageView {

    protected int size;
    protected int xPos;
    protected int yPos;
    protected float realY;
    private static final int FUDGE_FACTOR = 30;



    public Platform(Context context) {
        super(context);
        this.setImageResource(R.drawable.log);
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

    public int getYPos() {
        return yPos;
    }

    public int getSize() {
        return size;
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
