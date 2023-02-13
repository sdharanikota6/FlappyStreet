package com.example.flappy_street;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;

public class GameScreen extends AppCompatActivity {

    private DifficultyLevel difficulty;
    private int sprite;
    private Player player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra(ConfigScreen.CHOSEN_NAME);
        String difficultyString = intent.getStringExtra(ConfigScreen.CHOSEN_DIFFICULTY);
        String spriteString = intent.getStringExtra(ConfigScreen.CHOSEN_SPRITE);
        findDifficulty(difficultyString);
        findSprite(spriteString);
        player = new Player(name, difficulty);
        setContentView(R.layout.activity_game);

    }

    /**
     * Using a string representation, find and set the correct game difficulty.
     * @param diffString A string representation of GameDifficulty
     */
    private void findDifficulty(String diffString) {
        if (diffString.startsWith("E")) {
            this.difficulty = DifficultyLevel.EASY;
        } else if (diffString.startsWith("M")) {
            this.difficulty = DifficultyLevel.MEDIUM;
        } else {
            this.difficulty = DifficultyLevel.HARD;
        }
    }

    private void findSprite(String spriteString) {
        if (spriteString.endsWith("1")) {
            sprite = R.drawable.sprite1;
        } else if (spriteString.endsWith("2")) {
            sprite = R.drawable.sprite2;
        } else {
            sprite = R.drawable.sprite3;
        }

    }


}