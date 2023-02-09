package com.example.flappy_street.game;

import android.media.Image;

public class Player {

    private final String name;
    private Image sprite;
    private int lives;

    public Player(String name, DifficultyLevel difficulty, SpriteChoice spriteChoice) {
        this.name = name;
        //TODO: Decide on difficulty differences (meeting today!)
        lives = 5 - (2 * difficulty.ordinal()); //easy: 5 lives, medium: 3 lives, hard: 1.
        //something about sprite choice.
    }

    public String getName() {
        return this.name;
    }

    public void setSprite(Image sprite) {
        this.sprite = sprite;
    }

    public Image getSprite() {
        return this.sprite;
    }

    /**
     * Removes one life from the player. Returns the player's new amount of lives.
     * TODO: game over conditions
     * @return lives remaining after death
     */
    public int die() {
        return --lives;
    }

    public int getLives() {
        return lives;
    }

}
