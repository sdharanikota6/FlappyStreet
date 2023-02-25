package com.example.flappy_street.tiles;

import android.content.Context;
import android.util.AttributeSet;

import com.example.flappy_street.R;
import com.example.flappy_street.game.Player;

public class GoalTile extends GameTile {

    public GoalTile(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setImageResource(R.drawable.goal);
    }

    @Override
    public GameTile step(Player player) {
        player.win();
        return this;
    }
}
