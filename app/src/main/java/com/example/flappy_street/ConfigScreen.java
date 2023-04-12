package com.example.flappy_street;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.SpriteChoice;

public class ConfigScreen extends AppCompatActivity {

    private DifficultyLevel difficulty;
    private SpriteChoice chosenSprite;
    private Button[] difficultyButtons;
    private ImageButton[] spriteButtons;
    private boolean difficultyChosen = false;
    private boolean spriteChosen = false;
    private int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_config);
        Intent intent = getIntent();
        highScore = intent.getIntExtra("HighScore", 0);
        difficulty = DifficultyLevel.MEDIUM;
        chosenSprite = SpriteChoice.SPRITE_1;
        Button goButton = findViewById(R.id.goButton);
        goButton.setOnClickListener(this::goButton);

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

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(this::goBack);
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

    public void startGameScreen() {
        EditText textField = findViewById(R.id.editTextTextPersonName);
        String name = textField.getText().toString();
        Intent gameScreen = new Intent(this, GameScreen.class);
        gameScreen.putExtra("CHOSEN_DIFFICULTY", difficulty);
        gameScreen.putExtra("CHOSEN_SPRITE", chosenSprite);
        gameScreen.putExtra("CHOSEN_NAME", name);
        gameScreen.putExtra("HighScore", highScore);
        startActivity(gameScreen);
        finish();
    }

    private void goButton(View view) {
        String message;
        EditText username = (EditText) findViewById(R.id.editTextTextPersonName);
        if (usernameInvalid(username)) {
            message = "Invalid username, please try again";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        } else if (!difficultyChosen) {
            message = "Please select a difficulty level!";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        } else if (!spriteChosen) {
            message = "Please select a sprite!";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        } else {
            message = "Welcome " + username.getText().toString() + "!";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            startGameScreen();
        }
    }

    private boolean usernameInvalid(EditText userInput) {
        String usernameText = userInput.getText() == null ? "" : userInput.getText().toString();
        usernameText = usernameText.strip();
        return usernameText.isEmpty();
    }

    /**
     * Exits the config screen activity.
     * @param v the view that called this function
     */
    private void goBack(View v) {
        this.finish();
    }

    public int getHighScore() {
        return highScore;
    }

}