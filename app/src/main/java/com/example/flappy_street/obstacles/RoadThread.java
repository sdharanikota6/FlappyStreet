package com.example.flappy_street.obstacles;

import android.content.Context;

import java.util.Timer;

public class RoadThread extends Thread {

    private Context ctx;
    private Timer timer = new Timer();
    private VehicleRow[] rows;
    boolean running;

    public RoadThread(Context ctx, VehicleRow[] rows) {
        this.ctx = ctx;
        this.rows = rows;
    }

    public void run() {
        running = true;
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
