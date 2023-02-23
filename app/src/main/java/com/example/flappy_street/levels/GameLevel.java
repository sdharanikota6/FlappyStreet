package com.example.flappy_street.levels;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.GameTile;

public class GameLevel extends GridLayout {
    private static final int NUM_ROWS = 10;
    private static final int NUM_COLUMNS = 7;

    private GameTile[][] tileArray;
    private String name;

    public GameLevel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GameLevel init(GameTile[][] tileArray, Player player, String name) {
        this.tileArray = tileArray;
        this.name = name;
        return this;
    }

    /**
     * Returns a specific tile from the array.
     * @param x the x position in the array
     * @param y the y position in the array
     * @return the tile located at the provided position
     */
    public GameTile getTile(int x, int y) {
        return tileArray[x][y];
    }

    public String getName() {
        return name;
    }
}
