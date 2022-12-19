package com.example.finalprojectmad;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InformationScreen extends AppCompatActivity {
    Button BackHomeBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_screen);
        BackHomeBTN = findViewById(R.id.HomeBTN);
        BackHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }

            private void switchActivities() {
                Intent switchActivityIntent = new Intent(InformationScreen.this, HomePage.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}