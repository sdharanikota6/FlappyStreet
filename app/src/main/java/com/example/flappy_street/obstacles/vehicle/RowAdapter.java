package com.example.flappy_street.obstacles.vehicle;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.flappy_street.obstacles.vehicle.Vehicle;

public class RowAdapter extends BaseAdapter {

    private int count;
    private Vehicle[] vehicles;
    private ViewGroup.LayoutParams params;

    public RowAdapter(Context context, int count, Vehicle[] vehicles, int size) {
        this.count = count;
        this.vehicles = vehicles;
        Point screenSize = new Point(0, 0);
        Display display = ((DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE))
                .getDisplays()[0];
        display.getSize(screenSize);
        int length = screenSize.x * size / 7;
        params = new ViewGroup.LayoutParams(9 * length / 10, length / size);
        this.vehicles = vehicles;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public Object getItem(int i) {
        return vehicles[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        vehicles[i].setLayoutParams(params);
        return vehicles[i];
    }
}
