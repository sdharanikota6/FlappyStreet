package com.example.flappy_street.tiles;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.R;
import com.example.flappy_street.game.Player;

public class RoadTile extends GameTile {

    private boolean hasCoin;

    /**
     * @see AppCompatImageView#AppCompatImageView(Context, AttributeSet)
     * @param context The context this tile was created in
     */
    public RoadTile(Context context) {
        super(context);
        this.setImageResource(R.drawable.road);
        stepped = false;
    }

    public RoadTile(Context context, boolean hasCoin) {
        super(context);
        stepped = false;
        this.hasCoin = hasCoin;
        Resources r = getResources();
        Drawable[] coin = new Drawable[2];
        coin[0] = r.getDrawable(R.drawable.road);
        coin[1] = r.getDrawable(R.drawable.coin);
        LayerDrawable layerDrawable = new LayerDrawable(coin);
        this.setImageDrawable(layerDrawable);
    }

    /**
     * When a player steps on a road, score one point. <p>
     * {@inheritDoc}
     */
    @Override
    public GameTile step(Player player) {
        if (!stepped) {
            player.setScore(player.getScore() + 1);
        }
        if (hasCoin) {
            player.setScore(player.getScore() + 3);
        }
        this.setX(-10000);
        this.setY(-10000);
        stepped = true;
        hasCoin = false;
        return this;
    }
}
