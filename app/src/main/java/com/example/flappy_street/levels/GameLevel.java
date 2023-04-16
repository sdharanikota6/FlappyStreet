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

import java.util.Random;

public class GameLevel extends GridView {
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLUMNS = 7;

    private GameTile[][] tileArray;
    private String name;

//    private Random rand = new Random();
//    private int coin1 = rand.nextInt(7);
//    private int coin2 = rand.nextInt(7);
//    private int coin3 = rand.nextInt(7);
     //hardcoded for now bc its being weird with updating score for random pos
    private int coin1 = 2;
    private int coin2 = 4;
    private int coin3 = 3;

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
        tileArray[6][coin1] = new RoadTile(ctx, true);
        tileArray[7][coin2] = new RoadTile(ctx, true);
        tileArray[8][coin3] = new RoadTile(ctx, true);
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

    public void revertCoins() {
        tileArray[6][coin1] = new RoadTile(getContext(), true);
        tileArray[7][coin2] = new RoadTile(getContext(), true);
        tileArray[8][coin3] = new RoadTile(getContext(), true);
    }
}
