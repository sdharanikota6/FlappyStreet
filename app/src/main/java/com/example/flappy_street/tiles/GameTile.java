package com.example.flappy_street.tiles;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.example.flappy_street.game.Player;

/**
 * A {@code GameTile} is an {@code ImageView} that the player is able to step on.
 * When the player's position overlaps with the tile's position, then the function
 * {@code step(Player)} should be called.
 */
public abstract class GameTile extends AppCompatImageView {

    /** If the tile has been previously stepped on or not */
    protected boolean stepped;

    /**
     * @see AppCompatImageView#AppCompatImageView(Context, AttributeSet)
     * @param context The context this tile was created in
     */
    public GameTile(Context context) {
        super(context);
        stepped = false;
    }

    /**
     * When a player steps on this tile, execute this code. Typically, this will require some
     * modification of the player (movement, damage, score increase, etc.). <p>
     * Implementation should set "stepped" to true.
     * @param player the player object that stepped on this tile
     * @return An instance of the object that was stepped on.
     */
    public abstract GameTile step(Player player);

}
