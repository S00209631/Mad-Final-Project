package com.example.finalprojectmad;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
Button SubmitBTN;
Button PlayGameBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SubmitBTN = findViewById(R.id.SubmitBTN);
        EditText UserName = findViewById(R.id.UserName);
        String NameInput=  UserName.getText().toString();
        SharedPreferences SharedPreferences = getSharedPreferences("Shared_Pref_Name", MODE_PRIVATE);

        SubmitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
            private void switchActivities() {
                saveData();
                Intent switchActivityIntent = new Intent(MainActivity.this, HomePage.class);
                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Name", UserName.getText().toString());
                editor.apply();
                startActivity(switchActivityIntent);
            }

            private void saveData() {
            }
        });
    }
}