package com.example.flappy_street.tiles;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.R;
import com.example.flappy_street.game.Player;

public class SafeTile extends GameTile {

    /**
     * @see AppCompatImageView#AppCompatImageView(Context, AttributeSet)
     * @param context The context this tile was created in
     */
    public SafeTile(Context context) {
        super(context);
        this.setImageResource(R.drawable.safe);
        stepped = false;
    }

    /**
     * When a player steps on a safe tile, nothing happens. <p>
     * {@inheritDoc}
     */
    @Override
    public GameTile step(Player stepped) {
        return this;
    }
}
