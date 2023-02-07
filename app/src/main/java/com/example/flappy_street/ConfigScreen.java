package com.example.flappy_street;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flappy_street.activities.DifficultyButton;
import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

public class ConfigScreen extends AppCompatActivity {

    private Button goButton;
    private DifficultyLevel difficulty;
    private Player player;
    private EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_config);
        this.difficulty = DifficultyLevel.MEDIUM;
    }

    private void difficultyPress(View v) {
        DifficultyButton button = (DifficultyButton) v;
        button.setPressed(true);
    }
}