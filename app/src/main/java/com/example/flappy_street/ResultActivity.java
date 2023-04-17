package com.example.flappy_street;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.SpriteChoice;

public class ResultActivity extends AppCompatActivity {

    private int score;
    private int highScore;

    private SpriteChoice spriteString;
    private DifficultyLevel difficulty;
    private int lives;
    private String name;

    private TextView scoreView;
    private TextView highScoreView;
    private TextView title;
    private Button reset;
    private Button config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        highScore = intent.getIntExtra("HighScore", 0);
        lives = intent.getIntExtra("Lives", 0);
        scoreView = findViewById(R.id.displayStartingPoints);
        highScoreView = findViewById(R.id.displayHighScore);
        title = findViewById(R.id.endScreenTitle);
        String display = " ";
        scoreView.setText(display);
        display = "HighScore ";
        display += highScore;
        highScoreView.setText(display);
        if (lives > 0) {
            display = "You WIN";
            title.setText(display);
        } else {
            display = "You LOSE";
            title.setText(display);
        }
        reset = findViewById(R.id.RestartButton);
        config = findViewById(R.id.ConfigButton);
        reset.setOnClickListener((v) -> {
            resetButton();
        });
        config.setOnClickListener((v) -> {
            configButton();
        });
        name = intent.getStringExtra("Name");
        difficulty = (DifficultyLevel)
                intent.getSerializableExtra("Difficulty");
        spriteString = (SpriteChoice)
                intent.getSerializableExtra("Sprite");

    }

    public void resetButton() {
        finish();
        while (true) {
            System.exit(0);
        }
    }

    public void configButton() {
        Intent config = new Intent(getApplicationContext(), ConfigScreen.class);
        config.putExtra("HighScore", highScore);
        startActivity(config);
        finish();
    }

    public int getHighScore() {
        return highScore;
    }
}