package com.example.flappy_street;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.SpriteChoice;
import com.google.android.material.color.utilities.Score;

public class ResultActivity extends AppCompatActivity {

    private int score;
    private int highScore;

    private SpriteChoice spriteString;
    private DifficultyLevel difficulty;
    private String name;

    private TextView scoreView;
    private TextView highScoreView;
    private Button reset;
    private Button config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        score = intent.getIntExtra("Score", 0);
        highScore = intent.getIntExtra("HighScore", 0);
        scoreView = findViewById(R.id.displayStartingPoints);
        highScoreView = findViewById(R.id.displayHighScore);
        String display = "Score ";
        display += score;
        scoreView.setText(display);
        display = "HighScore ";
        display += highScore;
        highScoreView.setText(display);
        reset = findViewById(R.id.RestartButton);
        config = findViewById(R.id.ConfigButton);
        reset.setOnClickListener(this::resetButton);
        config.setOnClickListener(this::configButton);
        name = intent.getStringExtra("Name");
        difficulty = (DifficultyLevel)
                intent.getSerializableExtra("Difficulty");
        spriteString = (SpriteChoice)
                intent.getSerializableExtra("Sprite");
    }

    private void resetButton(View v) {
        Intent game = new Intent(getApplicationContext(), GameScreen.class);
        game.putExtra("CHOSEN_NAME", name);
        game.putExtra("CHOSEN_SPRITE", spriteString);
        game.putExtra("CHOSEN_DIFFICULTY", difficulty);
        startActivity(game);
    }

    private void configButton(View v) {
        Intent config = new Intent(getApplicationContext(), ConfigScreen.class);
        startActivity(config);
    }
}