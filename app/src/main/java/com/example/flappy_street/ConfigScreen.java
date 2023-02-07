package com.example.flappy_street;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

public class ConfigScreen extends AppCompatActivity {

    private Button goButton;
    private DifficultyLevel difficulty;
    private Button[] difficultyButtons;
    private Player player;
    private EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_config);
        this.difficulty = DifficultyLevel.MEDIUM;
        this.goButton = findViewById(R.id.goButton);
        this.difficultyButtons[0] = findViewById(R.id.easyButton);
        this.difficultyButtons[1] = findViewById(R.id.mediumButton);
        this.difficultyButtons[2] = findViewById(R.id.hardButton);
        for (Button button : difficultyButtons) {
            button.setOnClickListener(this::difficultyPress);
        }
    }

    public void difficultyPress(View v) {
        int pos = 4;
        Button pressed = (Button) v;
        for (int i = 0; i < 3; i++) {
            if (difficultyButtons[i] == pressed) {
                pos = i;
                difficultyButtons[i].setPressed(true);
            } else {
                difficultyButtons[i].setPressed(false);
            }
        }

        switch(pos) {
            case 0:
                difficulty = DifficultyLevel.EASY;
                break;
            case 1:
                difficulty = DifficultyLevel.MEDIUM;
                break;
            case 2:
                difficulty = DifficultyLevel.HARD;
                break;
            default:
                throw new IndexOutOfBoundsException("That button don't exist yo");
        }
    }
}