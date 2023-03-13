package com.example.flappy_street.obstacles;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.GridView;

import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.tiles.TileAdapter;

public class VehicleRow extends GridView {

    Vehicle[] vehicles;
    Context ctx;

    public VehicleRow(Context ctx) {
        super(ctx);
        this.ctx = ctx;
    }

    public VehicleRow(Context ctx, AttributeSet attrs) {
        super(ctx, attrs);
        this.ctx = ctx;
        this.init(Car.class, 3, 8);
        this.setNumColumns(3);
    }

    /**
     * Initializes a row of vehicles using a specific car class
     * @param vehicleType the class of the vehicle to generate
     * @param numVehicles the number of vehicles in this row
     * @param yPos the y position of this vehicle row (relative to the grid)
     * @return a reference to this object
     */
    public VehicleRow init(Class<? extends Vehicle> vehicleType,
                           int numVehicles,
                           int yPos) {
        vehicles = new Vehicle[numVehicles];
        for (int i = 0; i < numVehicles; i++) {
            try {
                Vehicle v = vehicleType.getConstructor(Context.class).newInstance(ctx);
                vehicles[i] = v;
            } catch (Exception e) {
                throw new UnsupportedOperationException("Initialization failed");
            }
        }
        this.setAdapter(new RowAdapter(ctx, numVehicles, vehicles, vehicles[0].getSize()));
        int backSpacing = (GameLevel.NUM_COLUMNS - numVehicles) / numVehicles;
        Point size = TileAdapter.getSize();
        int width = size.x / GameLevel.NUM_COLUMNS;
        this.setHorizontalSpacing(backSpacing * width);
        int height = width * yPos;
        this.setY(height);
        return this;
    }

    public void moveRow() {
        for (Vehicle v: vehicles) {
            v.move();
        }
    }
}
