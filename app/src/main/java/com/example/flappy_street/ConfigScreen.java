package com.example.flappy_street;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.SpriteChoice;
import com.example.flappy_street.game.Player;


public class ConfigScreen extends AppCompatActivity {
    private boolean inValid = false;
    private Button goButton;
    private DifficultyLevel difficulty;
    private SpriteChoice chosenSprite;
    private Button[] difficultyButtons;
    private ImageButton[] spriteButtons;
    private EditText textField;
    private boolean difficultyChosen = false;
    private boolean spriteChosen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_config);
        difficulty = DifficultyLevel.MEDIUM;
        chosenSprite = SpriteChoice.SPRITE_1;

        //Player player = new Player(username, difficulty, chosenSprite);
        goButton = findViewById(R.id.goButton);
        /*

        */
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message;
                EditText username = (EditText) findViewById(R.id.editTextTextPersonName);
                String usernameText = username.getText().toString();
                inValid = usernameText.isEmpty() || usernameText.isBlank();
                if (inValid) {
                    message = "Invalid username, please try again";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                } if (!inValid && !difficultyChosen) {
                    message = "Please select a difficulty level!";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                } if (!inValid && !spriteChosen) {
                    message = "Please select a sprite!";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                } if (!inValid && difficultyChosen && spriteChosen) {
                    message = "Welcome " + usernameText + "!";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    Intent gameScreen = new Intent(ConfigScreen.this, gameScreen.class);
                    startActivity(gameScreen);
                }
            }
        });



        difficultyButtons = new Button[3];
        difficultyButtons[0] = findViewById(R.id.easyButton);
        difficultyButtons[1] = findViewById(R.id.mediumButton);
        difficultyButtons[2] = findViewById(R.id.hardButton);
        for (Button button : difficultyButtons) {
            button.setOnClickListener(this::difficultyPress);
        }

        spriteButtons = new ImageButton[3];
        spriteButtons[0] = findViewById(R.id.spriteChoice1);
        spriteButtons[1] = findViewById(R.id.spriteChoice2);
        spriteButtons[2] = findViewById(R.id.spriteChoice3);
        for (ImageButton button : spriteButtons) {
            button.setOnClickListener(this::chooseSprite);
        }
    }

    /**
     * Choose the difficulty of the game.
     * @param v the view that called this method (should be a Button)
     */
    private void difficultyPress(View v) {
        Button pressed = (Button) v;
        for (int i = 0; i < 3; i++) {
            if (difficultyButtons[i] == pressed) {
                difficultyButtons[i].setEnabled(false);
                difficulty = DifficultyLevel.values()[i];
            } else {
                difficultyButtons[i].setEnabled(true);
            }
        }
        String difficultyString = "difficulty: " + difficulty;
        Toast.makeText(getApplicationContext(), difficultyString, Toast.LENGTH_SHORT).show();
        difficultyChosen = true;
    }

    private void chooseSprite(View v) {
        ImageButton pressed = (ImageButton) v;
        for (int i = 0; i < 3; i++) {
            if (spriteButtons[i] == pressed) {
                spriteButtons[i].setEnabled(false);
                chosenSprite = SpriteChoice.values()[i];
            } else {
                spriteButtons[i].setEnabled(true);
            }
        }
        String spriteString = "Sprite chosen: " + chosenSprite;
        Toast.makeText(getApplicationContext(), spriteString, Toast.LENGTH_SHORT).show();
        spriteChosen = true;
    }


}