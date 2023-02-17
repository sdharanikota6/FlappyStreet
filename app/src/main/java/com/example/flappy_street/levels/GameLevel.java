package com.example.flappy_street.levels;

import com.example.flappy_street.game.Player;
import com.example.flappy_street.tiles.GameTile;

public class GameLevel {
    private final GameTile[][] tileArray;
    private Player player; // Need access to player to set score and change lives
    private final String name;

    public GameLevel(GameTile[][] tileArray, Player player, String name) {
        this.tileArray = tileArray;
        this.player = player;
        this.name = name;
    }
}
