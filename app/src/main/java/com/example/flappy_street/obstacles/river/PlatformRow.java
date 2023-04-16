package com.example.flappy_street.obstacles.river;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.GridView;

import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.obstacles.RowAdapter;
import com.example.flappy_street.tiles.TileAdapter;

public class PlatformRow extends GridView {

    private int backendSpacing;
    private int spacing;
    private int yPos;
    private GameLevel level;
    private Platform[] platforms;
    private final Context context;
    private static final int NUM_COLUMNS = 7;

    public PlatformRow(Context ctx) {
        super(ctx);
        this.context = ctx;
        this.setNumColumns(NUM_COLUMNS);
    }

    public PlatformRow(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        this.context = ctx;
        this.setNumColumns(7);
    }

    public PlatformRow init(Class<? extends Platform> platformType,
                           int numPlatforms,
                           int yPos) {
        platforms = new Platform[numPlatforms];
        for (int i = 0; i < numPlatforms; i++) {
            try {
                Platform v = platformType.getConstructor(Context.class).newInstance(context);
                platforms[i] = v;
            } catch (Exception e) {
                throw new UnsupportedOperationException("Initialization failed");
            }
        }
        this.setAdapter(new RowAdapter(context, numPlatforms, platforms, platforms[0].getSize()));
        backendSpacing = (GameLevel.NUM_COLUMNS - numPlatforms) / numPlatforms;
        float spaceFloat = ((float) GameLevel.NUM_COLUMNS - numPlatforms) / numPlatforms;
        Point size = TileAdapter.getSize();
        int width = size.x / GameLevel.NUM_COLUMNS;
        spacing = (int) (spaceFloat * width);
        int height = width * yPos;
        this.setY(height);
        this.yPos = yPos;
        return this;
    }

    public void moveRow() {
        for (Platform v : platforms) {
            v.move();
        }
    }

    public void setPositions() {
        for (Platform platform : platforms) {
            platform.setGameLevel(level);
        }
        for (int i = 0; i < platforms.length; i++) {
            platforms[i].setXPos(i * backendSpacing);
            platforms[i].setX(i * spacing);
            platforms[i].setRealY(this.getY());
            platforms[i].setYPos(yPos);
        }
    }

    public PlatformRow setLevel(GameLevel level) {
        this.level = level;
        return this;
    }

    /**
     * Checks if a player has collided with a platform.
     * @param player the player's position
     */
    public void checkCollision(Player player) {
        for (Platform v : platforms) {
            v.collidesWith(player); //no if statement because movement handled within player
        }
    }
}
