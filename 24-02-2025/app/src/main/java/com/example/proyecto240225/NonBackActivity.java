package com.example.proyecto240225;

import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

public class NonBackActivity extends OnBackPressedCallback {

    private final AppCompatActivity activity;

    public NonBackActivity(AppCompatActivity activity) {
        super(true);
        this.activity = activity;
    }

    public NonBackActivity(boolean enabled, AppCompatActivity activity) {
        super(enabled);
        this.activity = activity;
    }

    @Override
    public void handleOnBackPressed() {

        Toast.makeText(activity, "Botón de retroceso bloqueado", Toast.LENGTH_SHORT).show();

    }
}
