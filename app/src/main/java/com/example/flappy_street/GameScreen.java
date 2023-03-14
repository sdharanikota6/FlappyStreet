package com.example.flappy_street;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.flappy_street.databinding.TestBinding;
import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.game.SpriteChoice;
import com.example.flappy_street.obstacles.Car;
import com.example.flappy_street.obstacles.RoadThread;
import com.example.flappy_street.obstacles.Semi;
import com.example.flappy_street.obstacles.Truck;
import com.example.flappy_street.obstacles.VehicleRow;

public class GameScreen extends AppCompatActivity {

    private int sprite;
    private Player player;
    private TestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        game();
    }

    private void initialize() {
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

        //findViewById(R.id.moveUP).setOnClickListener(player::moveUp);
        findViewById(R.id.moveUP).setOnClickListener((v) -> {
            player.moveUp(v);
            drawGame();
        });
        findViewById(R.id.moveDOWN).setOnClickListener((v) -> {
            player.moveDown(v);
            drawGame();
        });
        findViewById(R.id.moveLEFT).setOnClickListener((v) -> {
            player.moveLeft(v);
            drawGame();
        });
        findViewById(R.id.moveRIGHT).setOnClickListener((v) -> {
            player.moveRight(v);
            drawGame();
        });
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

        VehicleRow[] vehicles = new VehicleRow[3];
        vehicles[0] = ((VehicleRow) findViewById(R.id.carRow)).init(Car.class, 3, 8);
        vehicles[1] = ((VehicleRow) findViewById(R.id.truckRow)).init(Truck.class, 2, 7);
        vehicles[2] = ((VehicleRow) findViewById(R.id.semiRow)).init(Semi.class, 1, 6);
        RoadThread vehicleRun = new RoadThread(getApplicationContext(), vehicles);
        new Thread(vehicleRun).start();
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