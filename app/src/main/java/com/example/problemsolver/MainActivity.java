package com.example.problemsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the FWGC button */
    public void farmerButton(View view) {
        Intent intent = new Intent(this, DisplayFarmerActivity.class);
        startActivity(intent);
    }

    /** Called when the user taps the 8 PUZZLE button */
    public void puzzleButton(View view) {
        Intent intent = new Intent(this, DisplayPuzzleActivity.class);
        startActivity(intent);
    }
}
