package com.example.proyecto240225;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TertiaryActivity extends AppCompatActivity {

    TextView txvTitle;
    Button btnContinuar;
    ViewModel vm = new ViewModel();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tertiary);
        txvTitle = findViewById(R.id.txvTitle);
        txvTitle.setText(R.string.actividad_tres);
        btnContinuar = findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(v -> {
            vm.navegar(this, MainActivity.class);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getOnBackPressedDispatcher().addCallback(this, new NonBackActivity(this));
        
    }
}