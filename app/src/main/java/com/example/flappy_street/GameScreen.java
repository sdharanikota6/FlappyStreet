package com.example.flappy_street;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flappy_street.game.DifficultyLevel;
import com.example.flappy_street.game.Player;
import com.example.flappy_street.levels.GameLevel;
import com.example.flappy_street.game.SpriteChoice;

import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity implements View.OnClickListener {

    private DifficultyLevel difficulty;
    private int sprite;
    private Player player;
    private GameLevel level;

    private FrameLayout frame;
    private ImageView chosenSprite;
    private boolean actionUp;
    private boolean actionDown;
    private boolean actionLeft;
    private boolean actionRight;
    private Timer timer = new Timer();
    private Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra(ConfigScreen.CHOSEN_NAME);
        DifficultyLevel difficultyString = (DifficultyLevel)
                intent.getSerializableExtra(ConfigScreen.CHOSEN_DIFFICULTY);
        SpriteChoice spriteString = (SpriteChoice)
                intent.getSerializableExtra(ConfigScreen.CHOSEN_SPRITE);
        findSprite(spriteString);
        player = new Player(name, difficultyString);
        setContentView(R.layout.test);
        String display = "Difficulty: " + difficultyString;

        TextView startingPoints = findViewById(R.id.displayStartingPoints);
        display = "Points: " + player.getScore();
        startingPoints.setText(display);

        TextView displayLives = findViewById(R.id.displayStartingLives);
        display = "Lives: " + player.getLives();
        displayLives.setText(display);

        TextView playerName = findViewById(R.id.displayPlayerName);
        display = "Welcome " + player.getName();
        playerName.setText(display);

        chosenSprite = findViewById(R.id.spriteView);

        TextView highScore = findViewById(R.id.displayHighScore);
        if (player.getScore() > player.getHighScore()) {
            player.setHighScore(player.getScore());
        }
        display = "High Score: " + player.getHighScore();
        highScore.setText(display);

        ImageView chosenSprite = findViewById(R.id.spriteView);

        chosenSprite.setImageResource(sprite);


        frame = findViewById(R.id.frame);

        findViewById(R.id.moveUP).setOnClickListener(this);
        findViewById(R.id.moveDOWN).setOnClickListener(this);
        findViewById(R.id.moveLEFT).setOnClickListener(this);
        findViewById(R.id.moveRIGHT).setOnClickListener(this);



//        timer.schedule((new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        changePos(actionUp, actionLeft, actionDown, actionRight);
//                    }
//                });
//            }
//        }), 25, 10);
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

    /**
     * Sets boundaries and allows the sprite imageview to move around the screen.
     * @param actionUp checks if the upButton was activated and moves the player sprite up.
     * @param actionLeft checks if the LeftButton was activated and moves the player sprite Left.
     * @param actionDown checks if the DownButton was activated and moves the player sprite Down.
     * @param actionRight checks if the RightButton was activated and moves the player sprite Right.
     */
    public void changePos(boolean actionUp, boolean actionLeft, boolean actionDown,
                          boolean actionRight) {
        float spriteX = chosenSprite.getX();
        float spriteY = chosenSprite.getY();

        if (actionUp) {
            spriteY -= frame.getHeight() / 10.00;
            actionUp = false;
        } else if (actionDown) {
            spriteY += frame.getHeight() / 10.00;
        } else if (actionLeft) {
            spriteX -= frame.getWidth() / 70.00;
        } else if (actionRight) {
            spriteX += frame.getWidth() / 70.00;

        }


        if (spriteY < 0) {
            spriteY = 0;
        }
        if (spriteY > frame.getHeight() - chosenSprite.getHeight()) {
            spriteY = frame.getHeight() - chosenSprite.getHeight();
        }

        if (spriteX < 0) {
            spriteX = 0;
        }
        if (spriteX > frame.getWidth() - chosenSprite.getWidth()) {
            spriteX = frame.getWidth() - chosenSprite.getWidth();
        }

        chosenSprite.setX(spriteX);
        chosenSprite.setY(spriteY);
    }


    @Override
    public void onClick(View view/*, MotionEvent motionEvent*/) {
        if (view.getId() ==  R.id.moveUP) {
//            actionUp = true;
            changePos(true, false, false, false);
        }

        if (view.getId() == R.id.moveDOWN) {
            actionDown = true;
        }

        if (view.getId() == R.id.moveLEFT) {
            actionLeft = true;
        }

        if (view.getId() == R.id.moveRIGHT) {
            actionRight = true;
        }
    }

    public float getPosX() {
        return chosenSprite.getX();
    }

    public float getPosY() {
        return chosenSprite.getY();
    }

//    @Override
//    public void onClick(View view, ) {
//
//    }
}