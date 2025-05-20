package com.example.m5_02;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "CalorieLog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String input = "1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000";
        List<Integer> sums = CalorieCounter.sumCalories(input);
        int max = CalorieCounter.maxCalories(sums);

        for (int i = 0; i < sums.size(); i++) {
            Log.d(TAG, "Elfo " + (i+1) + ": " + sums.get(i) + " calorías");
        }
        Log.d(TAG, "Máximo de calorías: " + max);
    }
}