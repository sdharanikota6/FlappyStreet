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
import com.example.flappy_street.obstacles.Car;
import com.example.flappy_street.obstacles.RoadThread;
import com.example.flappy_street.obstacles.Semi;
import com.example.flappy_street.obstacles.Truck;
import com.example.flappy_street.obstacles.VehicleRow;

import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {

    private int sprite;
    private Player player;
    private final Timer timer = new Timer();
    private final Handler handler = new Handler();
    private RoadThread vehicleRun;
    private SpriteChoice spriteString;
    private DifficultyLevel difficulty;
    private String name;
    private int highScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        game();
    }

    private void initialize() {
        setContentView(R.layout.test);
        Intent intent = getIntent();
        name = intent.getStringExtra("CHOSEN_NAME");
        difficulty = (DifficultyLevel)
                intent.getSerializableExtra("CHOSEN_DIFFICULTY");
        spriteString = (SpriteChoice)
                intent.getSerializableExtra("CHOSEN_SPRITE");
        findSprite(spriteString);
        if (name == null) {
            name = "Test";
        }
        if (difficulty == null) {
            difficulty = DifficultyLevel.EASY;
        }
        player = ((Player) findViewById(R.id.player)).init(sprite, name, difficulty);
        highScore = intent.getIntExtra("HighScore", 0);
        player.setHighScore(highScore);
        VehicleRow[] vehicles = new VehicleRow[3];
        vehicles[0] = ((VehicleRow) findViewById(R.id.carRow))
                .init(Car.class, 3, 8);
        vehicles[1] = ((VehicleRow) findViewById(R.id.truckRow))
                .init(Truck.class, 2, 7);
        vehicles[2] = ((VehicleRow) findViewById(R.id.semiRow))
                .init(Semi.class, 1, 6);
        vehicleRun = new RoadThread(getApplicationContext(), vehicles, player);
        new Thread(vehicleRun).start();
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
            player.moveUp();
        });
        findViewById(R.id.moveDOWN).setOnClickListener((v) -> {
            player.moveDown();
        });
        findViewById(R.id.moveLEFT).setOnClickListener((v) -> {
            player.moveLeft();
        });
        findViewById(R.id.moveRIGHT).setOnClickListener((v) -> {
            player.moveRight();
        });
    }

    private void drawGame() {
        String display;
        TextView startingPoints = findViewById(R.id.displayStartingPoints);
        TextView displayLives = findViewById(R.id.displayStartingLives);
        TextView playerName = findViewById(R.id.displayPlayerName);
        TextView highScore = findViewById(R.id.displayHighScore);

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

        timer.schedule((new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (player.getLives() > 0) {
                            updateGame();
                            drawGame();
                        } else {
                            gameOver();
                        }
                    }
                });
            }
        }), 0, 20);
    }

    private void findSprite(SpriteChoice spriteString) {
        if (spriteString == null) {
            sprite = R.drawable.sprite1;
        } else {
            if (spriteString == SpriteChoice.SPRITE_1) {
                sprite = R.drawable.sprite1;
            } else if (spriteString == SpriteChoice.SPRITE_2) {
                sprite = R.drawable.sprite2;
            } else {
                sprite = R.drawable.sprite3;
            }
        }
    }

    public void gameOver() {
        vehicleRun.stopRows();
        timer.cancel();
        player.gameOver();
        Intent intent = new Intent(getApplicationContext(),
                ResultActivity.class);
        intent.putExtra("Score", player.getScore());
        intent.putExtra("HighScore", player.getHighScore());
        intent.putExtra("Sprite", spriteString);
        intent.putExtra("Name", name);
        intent.putExtra("Difficulty", difficulty);
        startActivity(intent);
        finish();
    }


    public int getHighScore() {
        return player.getHighScore();
    }
}