package com.example.flappy_street.obstacles;

import android.content.Context;

public class RoadThread extends Thread {

    private Context ctx;
    private VehicleRow[] rows;
    private boolean running;

    public RoadThread(Context ctx, VehicleRow[] rows) {
        this.ctx = ctx;
        this.rows = rows;
    }

    public void run() {
        running = true;
        for (VehicleRow row : rows) {
            row.setPositions();
        }
        while (running) {
            for (VehicleRow row : rows) {
                row.moveRow();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                break;
            }
        }
    }

    public void stopRows() {
        running = false;
    }


}
