package com.example.flappy_street;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startButton = findViewById(R.id.button);
        startButton.setOnClickListener(this::openConfig);
    }
    public void openConfig(View v) {
        Intent config = new Intent(this, ConfigScreen.class);
        startActivity(config);
        finish();
    }
}
