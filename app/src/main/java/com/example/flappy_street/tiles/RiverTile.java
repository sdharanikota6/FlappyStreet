package com.example.flappy_street.tiles;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.game.Player;

public class RiverTile extends GameTile {

    private boolean covered;
    /**
     * @see AppCompatImageView#AppCompatImageView(Context, AttributeSet)
     * @param context The context this tile was created in
     * @param attrs The attribute set used to create this (XML)
     */
    public RiverTile(Context context, AttributeSet attrs) {
        super(context, attrs);
        stepped = false;
        covered = false;
    }

    /**
     * On step, if the tile is not covered (by a log or whatever equivalent we're using),
     * kill the player. Stepping on a river tile is worth 5 points. 
     * @param stepped the player object that stepped on this tile
     * @return this tile
     */
    public GameTile step(Player stepped) {
        this.stepped = true;
        if (!covered) {
            stepped.die();
        }
        stepped.setScore(stepped.getScore() + 5);
        return this;
        //at the moment, I'm not sure if returning game tile is actually useful.
        //TODO: Once more progress on sprint made, reevaluate.
    }
}
