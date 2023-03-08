package com.example.flappy_street.game;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.levels.GameLevel;

public class Player extends AppCompatImageView {

    private GameLevel currentLevel;
    private String name;
    private int lives;
    private int score;
    private int highScore;
    private int xPos;
    private int yPos;

    public Player(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
    }

    public Player init(int sprite, String name, DifficultyLevel difficulty) {
        this.setImageResource(sprite);
        this.name = name;
        if (difficulty != null) {
            lives = 5 - (2 * difficulty.ordinal()); //easy: 5 lives, medium: 3 lives, hard: 1.
            score =  0;
            highScore = 0;
            //something about sprite choice.
        }
        this.setxPos(GameLevel.NUM_COLUMNS / 2);
        this.setyPos(GameLevel.NUM_ROWS - 1);
        return this;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
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

    public void moveUp() {
        this.yPos--;
        currentLevel.getTile(yPos, xPos).step(this);
    }

    public void moveDown() {
        this.yPos++;
        currentLevel.getTile(yPos, xPos).step(this);
    }

    public void moveLeft() {
        this.xPos--;
        currentLevel.getTile(yPos, xPos).step(this);
    }

    public void moveRight() {
        this.xPos++;
        currentLevel.getTile(yPos, xPos).step(this);
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
