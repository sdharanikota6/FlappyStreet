package com.example.flappy_street.obstacles;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class RowAdapter extends BaseAdapter {

    int count;
    Vehicle[] vehicles;

    public RowAdapter(int count, Vehicle[] vehicles) {
        this.count = count;
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
        return vehicles[i];
    }
}
