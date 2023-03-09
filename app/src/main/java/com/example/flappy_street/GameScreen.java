package com.example.flappy_street;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.game.SpriteChoice;

import java.util.Timer;

public class GameScreen extends AppCompatActivity {

    private int sprite;
    private Player player;
    private Timer timer = new Timer();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra(ConfigScreen.CHOSEN_NAME);
        DifficultyLevel difficulty = (DifficultyLevel)
                intent.getSerializableExtra(ConfigScreen.CHOSEN_DIFFICULTY);
        SpriteChoice spriteString = (SpriteChoice)
                intent.getSerializableExtra(ConfigScreen.CHOSEN_SPRITE);
        findSprite(spriteString);
        setContentView(R.layout.test);
        player = ((Player) findViewById(R.id.player)).init(sprite, name, difficulty);
        String display = "Difficulty: " + difficulty;

        TextView startingPoints = findViewById(R.id.displayStartingPoints);
        display = "Points: " + player.getScore();
        startingPoints.setText(display);

        TextView displayLives = findViewById(R.id.displayStartingLives);
        display = "Lives: " + player.getLives();
        displayLives.setText(display);

        TextView playerName = findViewById(R.id.displayPlayerName);
        display = "Welcome " + player.getName();
        playerName.setText(display);

        TextView highScore = findViewById(R.id.displayHighScore);
        if (player.getScore() > player.getHighScore()) {
            player.setHighScore(player.getScore());
        }
        display = "High Score: " + player.getHighScore();
        highScore.setText(display);

        findViewById(R.id.moveUP).setOnClickListener(player::moveUp);
        findViewById(R.id.moveDOWN).setOnClickListener(player::moveDown);
        findViewById(R.id.moveLEFT).setOnClickListener(player::moveLeft);
        findViewById(R.id.moveRIGHT).setOnClickListener(player::moveRight);

        //Setting GameLevel, hopefully this will fix crashes
        GameLevel level = new GameLevel(getApplicationContext());
        player.setGameLevel(level);
    }

    private void findSprite(SpriteChoice spriteString) {
        if (spriteString == SpriteChoice.SPRITE_1) {
            sprite = R.drawable.sprite1;
        } else if (spriteString == SpriteChoice.SPRITE_2) {
            sprite = R.drawable.sprite2;
        } else {
            sprite = R.drawable.sprite3;
        }
    }

    private void updateScoreText(TextView points) {
        String display = "Points: " + player.getScore();
        points.setText(display);
    }

    public float getPosX() {
        return player.getX();
    }

    public float getPosY() {
        return player.getY();
    }
}