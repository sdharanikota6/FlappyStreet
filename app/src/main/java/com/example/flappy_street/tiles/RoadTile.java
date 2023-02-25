package com.example.flappy_street.tiles;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.R;
import com.example.flappy_street.game.Player;

public class RoadTile extends GameTile {

    /**
     * @see AppCompatImageView#AppCompatImageView(Context, AttributeSet)
     * @param context The context this tile was created in
     * @param attrs The attribute set used to create this (XML)
     */
    public RoadTile(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setImageResource(R.drawable.road);
        stepped = false;
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
        stepped = true;
        return this;
    }
}
