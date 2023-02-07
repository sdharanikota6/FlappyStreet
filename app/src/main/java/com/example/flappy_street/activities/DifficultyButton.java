package com.example.flappy_street.activities;

import android.content.Context;
import android.graphics.Canvas;

import androidx.appcompat.widget.AppCompatButton;

import com.example.flappy_street.game.DifficultyLevel;

public class DifficultyButton extends AppCompatButton {

    private DifficultyLevel difficulty;

    public DifficultyButton(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public DifficultyLevel getDifficulty() {
        return this.difficulty;
    }

    private void setDifficulty(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
    }


}
