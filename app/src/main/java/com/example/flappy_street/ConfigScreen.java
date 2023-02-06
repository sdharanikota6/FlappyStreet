package com.example.flappy_street;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flappy_street.game.Player;

public class ConfigScreen extends AppCompatActivity {

    private Button goButton;
    private Player player;
    private EditText textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void onButtonPress(View v) {

    }
}