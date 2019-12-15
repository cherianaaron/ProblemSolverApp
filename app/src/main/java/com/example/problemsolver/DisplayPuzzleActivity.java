package com.example.problemsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DisplayPuzzleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_puzzle);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
    }

    /** Called when the user taps the Solve Farmer button */
    public void solvePuzzleButton(View view) {
        Intent intent = new Intent(this, PuzzleSolveActivity.class);
        startActivity(intent);
    }
}
