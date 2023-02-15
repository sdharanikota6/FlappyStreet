package com.example.flappy_street.game;

import com.example.flappy_street.tiles.GameTile;

public class Player {

    private GameTile currentTile;
    private final String name;
    private int lives;
    private int score;

    public Player(String name, DifficultyLevel difficulty) {
        this.name = name;
        lives = 5 - (2 * difficulty.ordinal()); //easy: 5 lives, medium: 3 lives, hard: 1.
        score = 0;
        //something about sprite choice.
    }

    public String getName() {
        return this.name;
    }

    /**
     * Removes one life from the player. Returns the player's new amount of lives.
     * @return lives remaining after death
     */
    public int die() {
        return --lives;
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

    public GameTile getCurrentTile() {
        return this.currentTile;
    }

    public void setCurrentTile(GameTile tile) {
        this.currentTile = tile;
    }

}
