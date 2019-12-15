package com.example.problemsolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DisplayFarmerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_farmer);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
    }

    /** Called when the user taps the Solve Farmer button */
    public void solveFarmerButton(View view) {
        Intent intent = new Intent(this, FarmerSolveActivity.class);
        startActivity(intent);
    }
}
