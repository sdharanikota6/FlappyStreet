package com.example.flappy_street.game;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.databinding.TestBinding;
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


    public Player(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
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
        Log.i("INIT", parentFrame.toString());

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
        this.highScore = newHighScore;
    }

    /**
     * Removes one life from the player. Returns the player's new amount of lives.
     * @return lives remaining after death
     */
    public int die() {
        return --lives;
    }

    public void win() {
        score += 100;
        Log.i("VICTORY", "Player wins!");
    }

    public void moveUp(View v) {
        if (yStep == 0) {
            yStep = parentFrame.getHeight() / (double) GameLevel.NUM_ROWS;
            Log.i("INIT", "Step Height: " + yStep);
        }
        if (yPos > 0) {
            yPos--;
            float newY =  (float) (getY() - yStep);
            setY(newY);
            currentLevel.getTile(yPos, xPos).step(this);
        }
        highScore++;

    }

    public void moveDown(View v) {
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

    }

    public void moveLeft(View v) {
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
    }

    public void moveRight(View v) {
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
