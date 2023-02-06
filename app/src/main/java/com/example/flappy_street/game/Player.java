package com.example.flappy_street.game;

import android.media.Image;

public abstract class Player {

    private String name;
    private Image sprite;
    private int lives;

    public void setName(String name) {
        this.name = name;
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

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLives() {
        return lives;
    }

}
