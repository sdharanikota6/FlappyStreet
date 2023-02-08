package com.example.flappy_street;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private boolean isEmpty(String input) {
        if (input.trim().length() > 0)
            return false;

        return true;
    }

    public void userInput(View v) {
        TextView t = findViewById(R.id.username);
        String name = t.getText().toString();

        if (name.isEmpty()) {
            Toast.makeText(this, "Enter a valid username!!", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("input", name);
    }

}