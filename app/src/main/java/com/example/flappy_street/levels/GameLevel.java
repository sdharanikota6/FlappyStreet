package com.example.flappy_street.levels;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.GridView;

import androidx.annotation.RequiresApi;

import com.example.flappy_street.tiles.GameTile;
import com.example.flappy_street.tiles.RoadTile;
import com.example.flappy_street.tiles.TileAdapter;

public class GameLevel extends GridView {
    private static final int NUM_ROWS = 10;
    private static final int NUM_COLUMNS = 7;

    private GameTile[][] tileArray;
    private String name;



    public GameLevel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        generateTileArray();
        this.setNumColumns(NUM_COLUMNS);
        this.setStretchMode(STRETCH_COLUMN_WIDTH);
        this.setHorizontalSpacing(0);
        this.setVerticalSpacing(0);
        this.setAdapter(new TileAdapter(context, tileArray));
    }

    public GameLevel init(GameTile[][] tileArray, String name) {
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

    /**
     * USED FOR TESTING: generate a tile array of all roads. using this just to try to
     * make sure things are displaying right
     */
    private void generateTileArray() {
        tileArray = new GameTile[NUM_ROWS][NUM_COLUMNS];
        for (GameTile[] row : tileArray) {
            for (int i = 0; i < row.length; i++) {
                row[i] = new RoadTile(getContext());
            }
        }
    }
}
