package com.example.flappy_street.obstacles;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class RowAdapter extends BaseAdapter {

    int count;
    Vehicle[] vehicles;
    ViewGroup.LayoutParams params;

    public RowAdapter(Context context, int count, Vehicle[] vehicles) {
        this.count = count;
        this.vehicles = vehicles;
        Point size = new Point(0,0);
        Display display = ((DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE)).
                getDisplays()[0];
        display.getSize(size);
        int length = size.x / 7;
        params = new ViewGroup.LayoutParams( 9 * length / 10 , length);
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
