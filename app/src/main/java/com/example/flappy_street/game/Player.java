package com.example.flappy_street.game;

import com.example.flappy_street.tiles.GameTile;

public class Player {

    private GameTile currentTile;
    private final String name;
    private int lives;
    private int score;

    private int highScore;
    private int xPos;
    private int yPos;

    public Player(String name, DifficultyLevel difficulty) {
        this.name = name;
        lives = 5 - (2 * difficulty.ordinal()); //easy: 5 lives, medium: 3 lives, hard: 1.
        score =  0;
        highScore = 0;
        //something about sprite choice.
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

    public GameTile getCurrentTile() {
        return this.currentTile;
    }

    public void setCurrentTile(GameTile tile) {
        this.currentTile = tile;
    }

}
