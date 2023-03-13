package com.example.flappy_street;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
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
    private DifficultyLevel difficulty;
    private TextView highScore;
    private TextView startingPoints;
    private TextView displayLives;
    private TextView playerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        game();
    }

    private void initialize() {
        setContentView(R.layout.test);
        Intent intent = getIntent();
        String name = intent.getStringExtra(ConfigScreen.CHOSEN_NAME);
        difficulty = (DifficultyLevel)
                intent.getSerializableExtra(ConfigScreen.CHOSEN_DIFFICULTY);
        SpriteChoice spriteString = (SpriteChoice)
                intent.getSerializableExtra(ConfigScreen.CHOSEN_SPRITE);
        findSprite(spriteString);
        player = ((Player) findViewById(R.id.player)).init(sprite, name, difficulty);
        startingPoints = findViewById(R.id.displayStartingPoints);
        displayLives = findViewById(R.id.displayStartingLives);
        playerName = findViewById(R.id.displayPlayerName);
        highScore = findViewById(R.id.displayHighScore);
        //Setting GameLevel, hopefully this will fix crashes
        GameLevel level = new GameLevel(getApplicationContext());
        player.setGameLevel(level);
    }

    private void updateGame() {
        if (player.getScore() > player.getHighScore()) {
            player.setHighScore(player.getScore());
        }
        findViewById(R.id.moveUP).setOnClickListener(player::moveUp);
        findViewById(R.id.moveDOWN).setOnClickListener(player::moveDown);
        findViewById(R.id.moveLEFT).setOnClickListener(player::moveLeft);
        findViewById(R.id.moveRIGHT).setOnClickListener(player::moveRight);
    }

    private void drawGame() {
        String display = "Difficulty: " + difficulty;

        display = "Welcome " + player.getName();
        playerName.setText(display);

        display = "Lives: " + player.getLives();
        displayLives.setText(display);

        display = "Points: " + player.getScore();
        startingPoints.setText(display);

        display = "High Score: " + player.getHighScore();
        highScore.setText(display);
    }

    private void game() {
        updateGame();
        drawGame();
        //set conditionals to move to other states underneath here.
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

    public float getPosX() {
        return player.getX();
    }

    public float getPosY() {
        return player.getY();
    }
}