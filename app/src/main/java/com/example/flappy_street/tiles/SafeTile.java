package com.example.flappy_street.tiles;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.game.Player;

public class SafeTile extends GameTile {

    /**
     * @see AppCompatImageView#AppCompatImageView(Context, AttributeSet)
     * @param context The context this tile was created in
     * @param attrs The attribute set used to create this (XML)
     */
    public SafeTile(Context context, AttributeSet attrs) {
        super(context, attrs);
        stepped = false;
    }

    /**
     * When a player steps on a safe tile, nothing happens. <p>
     * {@inheritDoc}
     */
    public GameTile step(Player stepped) {
        return this;
    }
}
