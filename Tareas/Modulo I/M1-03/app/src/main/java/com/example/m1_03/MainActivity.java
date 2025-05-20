package com.example.m1_03;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TiempoOrdenacion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int size = 1_000_000;
        int[] data = new int[size];
        Random rnd = new Random();
        for (int counter = 0; counter < size; counter++) {
            data[counter] = rnd.nextInt();
        }

        long inicio = System.nanoTime();
        Arrays.sort(data);
        long fin = System.nanoTime();
        long durationMs = (fin - inicio) / 1_000_000;

        Log.d(TAG, "Tiempo de ordenación: " + durationMs + " ms");
    }
}