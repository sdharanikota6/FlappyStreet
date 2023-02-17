package com.example.flappy_street.levels;

import android.content.Context;
import android.util.AttributeSet;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.GameTile;

public class GameLevel extends ConstraintLayout {
    private GameTile[][] tileArray;
    private Player player; // Need access to player to set score and change lives
    private String name;

    public GameLevel(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    public GameLevel init(GameTile[][] tileArray, Player player, String name) {
        this.tileArray = tileArray;
        this.player = player;
        this.name = name;
        return this;
    }

    public GameTile[][] getTileArray() {
        return tileArray;
    }

    public String getName() {
        return name;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
