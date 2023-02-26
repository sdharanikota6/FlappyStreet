package com.example.flappy_street.tiles;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class TileAdapter extends BaseAdapter {

    GameTile[][] tileArray;

    public TileAdapter(Context context, GameTile[][] tileArray) {
        this.tileArray = tileArray;
    }

    @Override
    public int getCount() {
        int count = 0;
        for (GameTile[] row : tileArray) {
            count += row.length;
        }
        return count;
    }

    @Override
    public Object getItem(int i) {
        int row = i / 7;
        int col = i % 7;
        return tileArray[row][col];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return (View) getItem(i);
    }
}
