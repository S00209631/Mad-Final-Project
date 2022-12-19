package com.example.finalprojectmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class HomePage extends AppCompatActivity {
    Button InformationBTN;
    Button PlayGameBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        InformationBTN = findViewById(R.id.InformationBTN);
        InformationBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }

            private void switchActivities() {
                Intent switchActivityIntent = new Intent(HomePage.this, InformationScreen.class);
                startActivity(switchActivityIntent);
            }
        });
        PlayGameBTN = findViewById(R.id.PlayGameBTN);
        PlayGameBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }

            private void switchActivities() {
                Intent switchActivityIntent = new Intent(HomePage.this, PlayScreen.class);
                startActivity(switchActivityIntent);
            }
        });
        // create an array of colors
        String[] colors = {"Red", "Blue", "Red", "Green"};

// create a random object
        Random rand = new Random();

// get a random color from the array
        String randomColor = colors[rand.nextInt(colors.length)];
    }
}