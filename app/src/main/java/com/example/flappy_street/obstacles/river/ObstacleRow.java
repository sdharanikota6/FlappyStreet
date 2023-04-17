package com.example.flappy_street.obstacles.river;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.GridView;

import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.obstacles.Obstacle;
import com.example.flappy_street.obstacles.RowAdapter;
import com.example.flappy_street.tiles.TileAdapter;

public class ObstacleRow extends GridView {

    private int backendSpacing;
    private int spacing;
    private int yPos;
    private GameLevel level;
    private Obstacle[] obstacles;
    private final Context context;
    private static final int NUM_COLUMNS = 7;

    public ObstacleRow(Context ctx) {
        super(ctx);
        this.context = ctx;
        this.setNumColumns(NUM_COLUMNS);
    }

    public ObstacleRow(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        this.context = ctx;
        this.setNumColumns(7);
    }

    public ObstacleRow init(Class<? extends Obstacle> platformType,
                            int numPlatforms,
                            int yPos) {
        obstacles = new Obstacle[numPlatforms];
        for (int i = 0; i < numPlatforms; i++) {
            try {
                Obstacle v = platformType.getConstructor(Context.class).newInstance(context);
                obstacles[i] = v;
            } catch (Exception e) {
                throw new UnsupportedOperationException("Initialization failed");
            }
        }
        this.setAdapter(new RowAdapter(context, numPlatforms, obstacles, obstacles[0].getSize()));
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
        for (Obstacle v : obstacles) {
            v.move();
        }
    }

    public void setPositions() {
        for (Obstacle platform : obstacles) {
            platform.setGameLevel(level);
        }
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i].setXPos(i * backendSpacing);
            obstacles[i].setX(i * spacing);
            obstacles[i].setRealY(this.getY());
            obstacles[i].setYPos(yPos);
        }
    }

    public ObstacleRow setLevel(GameLevel level) {
        this.level = level;
        return this;
    }

    /**
     * Checks if a player has collided with a platform.
     * @param player the player's position
     */
    public void checkCollision(Player player) {
        for (Obstacle v : obstacles) {
            v.collidesWith(player); //no if statement because movement handled within player
        }
    }
}
