package com.example.m5_01;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private TextView tvFibonacciIndex, tvFibonacciIterative, tvFibonacciRecursive;
    private Button btnNext, btnPrevious;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvFibonacciIndex = findViewById(R.id.tvFibonacciIndex);
        tvFibonacciIterative = findViewById(R.id.tvFibonacciIterative);
        tvFibonacciRecursive = findViewById(R.id.tvFibonacciRecursive);
        btnNext = findViewById(R.id.btnAvance);
        btnPrevious = findViewById(R.id.btnRetroceso);

        btnNext.setOnClickListener(v -> {
            index++;
            updateView();
        });
        btnPrevious.setOnClickListener(v -> {
            if (index > 0) index--;
            updateView();
        });

        updateView();
    }

    private void updateView() {
        long iterValue = IterativeFibonacci.calculate(index);
        long recValue = RecursiveFibonacci.calculate(index);
        tvFibonacciIndex.setText(getString(R.string.fibonacci_message_index, index));
        tvFibonacciIterative.setText(getString(R.string.fibonacci_message_iterative, iterValue));
        tvFibonacciRecursive.setText(getString(R.string.fibonacci_message_recursive, recValue));
    }
}