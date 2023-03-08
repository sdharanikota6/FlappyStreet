package com.example.flappy_street;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.game.SpriteChoice;

import java.util.Timer;

public class GameScreen extends AppCompatActivity {

    private DifficultyLevel difficulty;
    private int sprite;
    private Player player;
    private GameLevel level;

    private FrameLayout frame;
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

        frame = findViewById(R.id.frame);

        findViewById(R.id.moveUP).setOnClickListener(this::moveUp);
        findViewById(R.id.moveDOWN).setOnClickListener(this::moveDown);
        findViewById(R.id.moveLEFT).setOnClickListener(this::moveLeft);
        findViewById(R.id.moveRIGHT).setOnClickListener(this::moveRight);

        //Setting GameLevel, hopefully this will fix crashes
        level = new GameLevel(getApplicationContext());
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

    public void moveUp(View view) {
        float spriteX = player.getX();
        float spriteY = player.getY();

        spriteY -= frame.getHeight() / (double) GameLevel.NUM_ROWS;
        if (player.getyPos() > 0) {
            player.moveUp();
        }
        if (spriteY < 0) {
            spriteY = 0;
        }

        player.setX(spriteX);
        player.setY(spriteY);
    }

    public void moveLeft(View view) {
        float spriteX = player.getX();
        float spriteY = player.getY();

        spriteX -= frame.getWidth() / (double) GameLevel.NUM_COLUMNS;
        if (player.getxPos() > 0) {
            player.moveLeft();
        }
        if (spriteX < 0) {
            spriteX = 0;
        }

        player.setX(spriteX);
        player.setY(spriteY);
    }

    public void moveDown(View view) {
        float spriteX = player.getX();
        float spriteY = player.getY();

        spriteY += frame.getHeight() / (double) GameLevel.NUM_ROWS;
        if (player.getyPos() < GameLevel.NUM_ROWS - 1) {
            player.moveDown();
        }
        if (spriteY > frame.getHeight() - player.getHeight()) {
            spriteY = frame.getHeight() - player.getHeight();
        }

        player.setX(spriteX);
        player.setY(spriteY);
    }

    public void moveRight(View view) {
        float spriteX = player.getX();
        float spriteY = player.getY();

        spriteX += frame.getWidth() / (double) GameLevel.NUM_COLUMNS;
        if (player.getxPos() < GameLevel.NUM_COLUMNS - 1) {
            player.moveRight();
        }
        if (spriteX > frame.getWidth() - player.getWidth()) {
            spriteX = frame.getWidth() - player.getWidth();
        }

        player.setX(spriteX);
        player.setY(spriteY);
    }

    public float getPosX() {
        return player.getX();
    }

    public float getPosY() {
        return player.getY();
    }
}