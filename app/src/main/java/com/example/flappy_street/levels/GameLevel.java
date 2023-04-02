package com.example.flappy_street.levels;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import com.example.flappy_street.tiles.GameTile;
import com.example.flappy_street.tiles.GoalTile;
import com.example.flappy_street.tiles.RiverTile;
import com.example.flappy_street.tiles.RoadTile;
import com.example.flappy_street.tiles.SafeTile;
import com.example.flappy_street.tiles.TileAdapter;

public class GameLevel extends GridView {
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLUMNS = 7;

    private GameTile[][] tileArray;
    private String name;

    /**
     * Constructor used for unit testing
     * @param context the context this view was created in
     */
    public GameLevel(Context context) {
        super(context);
        generateTileArray();
        this.setNumColumns(NUM_COLUMNS);
        this.setStretchMode(STRETCH_COLUMN_WIDTH);
        this.setHorizontalSpacing(0);
        this.setVerticalSpacing(0);
        this.setAdapter(new TileAdapter(context, tileArray));
    }

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
     * Creates the tile array used to play the game.
     */
    private void generateTileArray() {
        tileArray = new GameTile[NUM_ROWS][NUM_COLUMNS];
        Context ctx = getContext();
        //goal row
        for (int i = 0; i < tileArray[0].length; i++) {
            tileArray[0][i] = new GoalTile(ctx);
        }
        //river rows
        for (int j = 1; j < 5; j++) {
            for (int i = 0; i < tileArray[j].length; i++) {
                tileArray[j][i] = new RiverTile(ctx);
            }
        }
        //safe row
        for (int i = 0; i < tileArray[0].length; i++) {
            tileArray[5][i] = new SafeTile(ctx);
        }
        //road rows
        for (int j = 6; j < 9; j++) {
            for (int i = 0; i < tileArray[j].length; i++) {
                tileArray[j][i] = new RoadTile(ctx);
            }
        }
        //spawn row
        for (int i = 0; i < tileArray[0].length; i++) {
            tileArray[9][i] = new SafeTile(ctx);
        }
    }

    /**
     * Sets all tiles in a row to stepped for scoring purposes.
     *
     * @param yPos the row to set
     */
    public void setRowStepped(int yPos) {
        for (int i = 0; i < NUM_COLUMNS; i++) {
            tileArray[yPos][i].setStepped(true);
        }
    }

    public void setRowUnstepped(int yPos) {
        for (int i = 0; i < NUM_COLUMNS; i++) {
            tileArray[yPos][i].setStepped(false);
        }
    }
}
