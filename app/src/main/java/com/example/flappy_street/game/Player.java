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
    private final int[] startingPos = {GameLevel.NUM_COLUMNS / 2, GameLevel.NUM_ROWS - 1}; // {x, y}

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
     * Player checks its current x position and updates the backend position accordingly.
     */
    public void updateXPos() {
        float x = this.getX();
        this.xPos = (int) (x / (float) xStep);
    }

    /**
     * Removes one life from the player. Returns the player's new amount of lives.
     * @return lives remaining after death
     */
    public int die() {
        this.setScore(0); //Reset score to 0
        this.resetPos();
        return --lives;

    }

    public void win() {
        score += 100;
        Log.i("VICTORY", "Player wins!");
    }
  
    public void resetPos() {
        int yDis = yPos - startingPos[1];
        int xDis = xPos - startingPos[0];
        yPos = startingPos[1];
        xPos = startingPos[0];
        if (parentFrame != null) {
            if (yStep == 0) {
                yStep = parentFrame.getHeight() / (double) GameLevel.NUM_ROWS;
            }
            if (xStep == 0) {
                xStep = parentFrame.getWidth() / (double) GameLevel.NUM_COLUMNS;
            }
        } else {
            if (yStep == 0) {
                yStep = 100 / (double) GameLevel.NUM_ROWS;
            }
            if (xStep == 0) {
                xStep = 100 / (double) GameLevel.NUM_COLUMNS;
            }
        }
        setY((float) (getY() - ((yStep) * yDis)));
        setX((float) (getX() - ((xStep) * xDis)));
        //Reset rows to unstepped
        if (currentLevel != null) {
            for (int i = 0; i < GameLevel.NUM_ROWS; i++) {
                currentLevel.setRowUnstepped(i);
            }
        }
    }

    public void gameOver() {
        if (lives == 0) {
            setHighScore(score);
        }
    }

    /**
     * Added checks for parentsFrame in order to complete testing of movement.
     */
    public void moveUp() {
        initializeMovement();
        if (yPos > 0) {
            yPos--;
            float newY = (float) ((yPos * yStep) + (yStep / 7.5));
            //float newY =  (float) (getY() - yStep); // Put snapping here
            setY(newY);
            if (parentFrame != null) {
                currentLevel.getTile(yPos, xPos).step(this);
                currentLevel.setRowStepped(yPos);
            }
        }
    }

    public void moveDown() {
        initializeMovement();
        if (yPos < GameLevel.NUM_ROWS - 1) {
            yPos++;
            //float newY =  (float) (getY() + yStep);
            float newY = (float) ((yPos * yStep) + (yStep / 7.5));
            setY(newY);
            if (parentFrame != null) {
                currentLevel.getTile(yPos, xPos).step(this);
            }
        }
    }

    public void moveLeft() {
        initializeMovement();
        if (xPos > 0) {
            xPos--;
            //float newX =  (float) (getX() - xStep);
            float newX = (float) ((xPos * xStep) + (xStep / 11));
            setX(newX);
            if (parentFrame != null) {
                currentLevel.getTile(yPos, xPos).step(this);
            }
        }
    }

    public void moveRight() {
        initializeMovement();
        if (xPos < GameLevel.NUM_COLUMNS - 1) {
            xPos++;
            //float newX =  (float) (getX() + xStep);
            float newX = (float) ((xPos * xStep) + (xStep / 11));
            setX(newX);
            if (parentFrame != null) {
                currentLevel.getTile(yPos, xPos).step(this);
            }
        }
    }

    private void initializeMovement() {
        if (parentFrame != null) {
            if (xStep == 0) {
                xStep = parentFrame.getWidth() / (double) GameLevel.NUM_COLUMNS;
                Log.i("INIT", "Step Width: " + xStep);
            }
            if (yStep == 0) {
                yStep = parentFrame.getHeight() / (double) GameLevel.NUM_ROWS;
                Log.i("INIT", "Step Height: " + yStep);
            }
        } else {
            if (xStep == 0) {
                xStep = 100 / (double) GameLevel.NUM_COLUMNS;
                Log.i("INIT", "Step Width: " + xStep);
            }
            if (yStep == 0) {
                yStep = 100 / (double) GameLevel.NUM_ROWS;
                Log.i("INIT", "Step Height: " + yStep);
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
}
