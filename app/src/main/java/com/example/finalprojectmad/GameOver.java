package com.example.finalprojectmad;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {
    Button PlayAgainBTN;
    Button GobackHome;

    TextView Tv_Score , Score;
    int lastScore;
    String UserNAME;
    String Name;
    String UserName1;
    String UserName2;
    String UserName3;


    int Best1;
    int Best2;
    int Best3;
    int Best4;
    int Best5;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        PlayAgainBTN = findViewById(R.id.PlayAgainBTN);
        GobackHome = findViewById(R.id.GobackHome);

        Tv_Score = (TextView) findViewById(R.id.Tv_Score);
        Score = (TextView) findViewById(R.id.Score);

        SharedPreferences preferences = getSharedPreferences("PREFS",0);
        lastScore = preferences.getInt("lastScore",0);
        UserNAME = preferences.getString("Name","");

        UserName1 = preferences.getString("Name1","");
        UserName2 = preferences.getString("Name2","");
        UserName3 = preferences.getString("Name3","");

        Best1 = preferences.getInt("Best1",0);
        Best2 = preferences.getInt("Best2",0);
        Best3 = preferences.getInt("Best3",0);

        if (lastScore > Best3){
            Best3=lastScore;
             SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best 3 ", Best3);
            editor.apply();
        }
        if (lastScore > Best2){
            int temp = Best2;
            Best2=lastScore;
            Best3 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best 3 ", Best3);
            editor.putInt("Best 2 ", Best2);

            editor.apply();

        }
        if (lastScore > Best1){
            int temp = Best1;
            Best1=lastScore;
            Best2 = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Best 2 " , Best2);
            editor.putInt("Best 1 ", Best1);

            editor.apply();

        }
        Score.setText("Your Last Score Was :" + lastScore + "\n" );

        Tv_Score.setText(
                UserNAME + Best1 + "\n" +
                UserNAME + Best2 + "\n" +
                UserNAME + Best3 + "\n");


        PlayAgainBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }

            private void switchActivities() {
                Intent switchActivityIntent = new Intent(GameOver.this, PlayScreen.class);
                startActivity(switchActivityIntent);
            }
        });
        GobackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }

            private void switchActivities() {
                Intent switchActivityIntent = new Intent(GameOver.this, HomePage.class);
                startActivity(switchActivityIntent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), PlayScreen.class);
        startActivity(intent);
        finish();
    }
}