package com.example.flappy_street.tiles;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.R;
import com.example.flappy_street.game.Player;

public class RiverTile extends GameTile {

    private boolean covered;
    /**
     * @see AppCompatImageView#AppCompatImageView(Context, AttributeSet)
     * @param context The context this tile was created in
     */
    public RiverTile(Context context) {
        super(context);
        this.setImageResource(R.drawable.river);
        stepped = false;
        covered = false;
    }

    /**
     * On step, if the tile is not covered (by a log or whatever equivalent we're using),
     * kill the player. Stepping on a river tile is worth 5 points. <p>
     * {@inheritDoc}
     */
    @Override
    public GameTile step(Player player) {
        if (!stepped) {
            player.setScore(player.getScore() + 5);
        }
        this.stepped = true;
        if (!covered) {
            player.die();
        }
        return this;
    }

    public void cover() {
        this.covered = true;
    }

    public void uncover() {
        this.covered = false;
    }

    public boolean isCovered() {
        return covered;
    }
}
