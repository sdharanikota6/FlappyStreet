package com.example.flappy_street.obstacles;

import android.content.Context;

import com.example.flappy_street.game.Player;

public class RoadThread extends Thread {

    private Context ctx;
    private ObstacleRow[] rows;
    //private ObstacleRow[] platRows;
    private Player player;
    private boolean running;

    public RoadThread(Context ctx, ObstacleRow[] rows,  Player player) {
        this.ctx = ctx;
        this.rows = rows;
        this.player = player;
    }

    /**
     * Creates a new roadThread, responsible for updating each row's position
     * and detecting player collisions.
     */
    public void run() {
        running = true;
        for (ObstacleRow row : rows) {
            row.setPositions();
        }
        while (running) {
            for (ObstacleRow row : rows) {
                row.moveRow();
                row.checkCollision(player);
            }
            try {
                Thread.sleep(14);
            } catch (InterruptedException ie) {
                break;
            }
        }
    }

    public void stopRows() {
        running = false;
    }


}
