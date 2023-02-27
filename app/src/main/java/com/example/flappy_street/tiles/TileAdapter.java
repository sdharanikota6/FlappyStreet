package com.example.flappy_street.tiles;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class TileAdapter extends BaseAdapter {

    private ViewGroup.LayoutParams params;
    private GameTile[][] tileArray;

    public TileAdapter(Context context, GameTile[][] tileArray) {
        Point size = new Point(0, 0);
        Display display = ((DisplayManager) context.getSystemService(Context.DISPLAY_SERVICE)).
                getDisplays()[0];
        display.getSize(size);
        int length = size.x / 7;
        params = new ViewGroup.LayoutParams(length, length);
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
        GameTile tile = tileArray[i / 7][i % 7];
        tile.setLayoutParams(params);
        tile.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return tile;
    }
}
