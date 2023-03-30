package com.example.flappy_street.game;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.levels.GameLevel;

public class Player extends AppCompatImageView {

    private GameLevel currentLevel;
    private String name;
    private FrameLayout parentFrame;
    private int lives;
    private int score;
    private int highScore;
    private int xPos;
    private int yPos;
    private double yStep;
    private double xStep;
    private int[] lastSafePos; // {x, y}

    public Player(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
    }

    public Player(Context ctx) {
        super(ctx);
    }

    public Player init(int sprite, String name, DifficultyLevel difficulty) {
        this.setImageResource(sprite);
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be only whitespace or null");
        }
        this.name = name;
        if (difficulty != null) {
            lives = 5 - (2 * difficulty.ordinal()); //easy: 5 lives, medium: 3 lives, hard: 1.
            score =  0;
            highScore = 0;
            //something about sprite choice.
        }
        xPos = GameLevel.NUM_COLUMNS / 2;
        yPos = GameLevel.NUM_ROWS - 1;
        parentFrame = (FrameLayout) this.getParent();
        return this;
    }

    public String getName() {
        return this.name;
    }

    public int getLives() {
        return lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int newScore) {
        this.score = newScore;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int newHighScore) {
        if (newHighScore > highScore) {
            this.highScore = newHighScore;
        }
    }

    /**
     * Removes one life from the player. Returns the player's new amount of lives.
     * @return lives remaining after death
     */
    public int die() {
        if (lives - 1 ==0) {
            //TODO game over process
        }
        this.setScore(0); //Reset score to 0
        //TODO die animation?
        while (xPos > lastSafePos[0]) {
            moveLeft();
        }
        while (xPos < lastSafePos[0]) {
            moveRight();
        }
        while (yPos > lastSafePos[1]) {
            moveUp();
        }
        while (yPos < lastSafePos[1]) {
            moveDown();
        }
        return --lives;

    }

    public void win() {
        score += 100;
        Log.i("VICTORY", "Player wins!");
    }

    /**
     * Added checks for parentsFrame in order to complete testing of movement.
     */
    public void moveUp() {
        if (parentFrame != null) {
            if (yStep == 0) {
                yStep = parentFrame.getHeight() / (double) GameLevel.NUM_ROWS;
                Log.i("INIT", "Step Height: " + yStep);
            }
            if (yPos > 0) {
                yPos--;
                float newY =  (float) (getY() - yStep);
                setY(newY);
                currentLevel.getTile(yPos, xPos).step(this);
                currentLevel.setRowStepped(yPos);
            }
        } else {
            if (yStep == 0) {
                yStep = 100 / (double) GameLevel.NUM_ROWS;
                Log.i("INIT", "Step Height: " + yStep);
            }
            if (yPos > 0) {
                yPos--;
                float newY =  (float) (getY() - yStep);
                setY(newY);
            }
        }
    }

    public void moveDown() {
        if (parentFrame != null) {
            if (yStep == 0) {
                yStep = parentFrame.getHeight() / (double) GameLevel.NUM_ROWS;
                Log.i("INIT", "Step Height: " + yStep);
            }
            if (yPos < GameLevel.NUM_ROWS - 1) {
                yPos++;
                float newY =  (float) (getY() + yStep);
                setY(newY);
                currentLevel.getTile(yPos, xPos).step(this);
            }

        } else {
            if (yStep == 0) {
                yStep = 100 / (double) GameLevel.NUM_ROWS;
                Log.i("INIT", "Step Height: " + yStep);
            }
            if (yPos < GameLevel.NUM_ROWS - 1) {
                yPos++;
                float newY =  (float) (getY() + yStep);
                setY(newY);
            }
        }
    }

    public void moveLeft() {
        if (parentFrame != null) {
            if (xStep == 0) {
                xStep = parentFrame.getWidth() / (double) GameLevel.NUM_COLUMNS;
                Log.i("INIT", "Step Width: " + xStep);
            }
            if (xPos > 0) {
                xPos--;
                float newX =  (float) (getX() - xStep);
                setX(newX);
                currentLevel.getTile(yPos, xPos).step(this);
            }
        } else {
            if (xStep == 0) {
                xStep = 100 / (double) GameLevel.NUM_COLUMNS;
                Log.i("INIT", "Step Width: " + xStep);
            }
            if (xPos > 0) {
                xPos--;
                float newX =  (float) (getX() - xStep);
                setX(newX);
            }
        }
    }

    public void moveRight() {
        if (parentFrame != null) {
            if (xStep == 0) {
                xStep = parentFrame.getWidth() / (double) GameLevel.NUM_COLUMNS;
                Log.i("INIT", "Step Width: " + xStep);
            }
            if (xPos < GameLevel.NUM_COLUMNS - 1) {
                xPos++;
                float newX =  (float) (getX() + xStep);
                setX(newX);
                currentLevel.getTile(yPos, xPos).step(this);
            }
        } else {
            if (xStep == 0) {
                xStep = 100 / (double) GameLevel.NUM_COLUMNS;
                Log.i("INIT", "Step Width: " + xStep);
            }
            if (xPos < GameLevel.NUM_COLUMNS - 1) {
                xPos++;
                float newX =  (float) (getX() + xStep);
                setX(newX);
            }
        }

    }

    /**
     * Currently for testing purposes, might be needed in implementation.
     *
     * @param gameLevel the GameLevel to set
     */
    public void setGameLevel(GameLevel gameLevel) {
        this.currentLevel = gameLevel;
    }

    public void setLastSafePos(int[] pos) {
        this.lastSafePos = pos;
    }

    public int[] getCurrPosition() {
        return new int[]{xPos, yPos};
    }
}
