package com.example.flappy_street;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.flappy_street.databinding.TestBinding;
import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.game.SpriteChoice;

import java.util.Timer;

public class GameScreen extends AppCompatActivity {

    private int sprite;
    private Player player;
    TestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        game();
    }

    private void initialize() {
//        setContentView(R.layout.test);
        binding = binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        Intent intent = getIntent();
        String name = intent.getStringExtra(ConfigScreen.CHOSEN_NAME);
        DifficultyLevel difficulty = (DifficultyLevel)
                intent.getSerializableExtra(ConfigScreen.CHOSEN_DIFFICULTY);
        SpriteChoice spriteString = (SpriteChoice)
                intent.getSerializableExtra(ConfigScreen.CHOSEN_SPRITE);
        findSprite(spriteString);
        player = ((Player) findViewById(R.id.player)).init(sprite, name, difficulty);
        //Setting GameLevel, hopefully this will fix crashes
        GameLevel level = new GameLevel(getApplicationContext());
        player.setGameLevel(level);
    }

    private void updateGame() {
        if (player.getScore() > player.getHighScore()) {
            player.setHighScore(player.getScore());
        }
        display = "High Score: " + player.getHighScore();
        highScore.setText(display);

        //findViewById(R.id.moveUP).setOnClickListener(player::moveUp);
        findViewById(R.id.moveUP).setOnClickListener((v) -> {
            player.moveUp(v);
            updateScoreText(startingPoints);
        });

        findViewById(R.id.moveDOWN).setOnClickListener(player::moveDown);
        findViewById(R.id.moveLEFT).setOnClickListener(player::moveLeft);
        findViewById(R.id.moveRIGHT).setOnClickListener(player::moveRight);
    }

    private void drawGame() {
        String display;

        display = "Welcome " + player.getName();
        binding.displayPlayerName.setText(display);

        display = "Lives: " + player.getLives();
        binding.displayStartingLives.setText(display);

        display = "Points: " + player.getScore();
        binding.displayStartingPoints.setText(display);

        display = "High Score: " + player.getHighScore();
        binding.displayHighScore.setText(display);
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