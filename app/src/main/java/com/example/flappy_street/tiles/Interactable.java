package com.example.flappy_street.tiles;

import com.example.flappy_street.game.Player;

/**
 * An {@code Interactable} is an object that can be stepped on by a player.
 */
@FunctionalInterface
public interface Interactable {

    /**
     * When a player steps on this tile, execute this code. Typically, this will require some
     * modification of the player (movement, damage, score increase, etc.).
     * @param player the player object that stepped on this tile
     * @return An instance of the object that was stepped on.
     */
    Interactable onStep(Player player);
}
