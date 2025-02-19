package com.example.calculadora_19_02;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    long fibonnacciUno = 1;
    long fibonnacciDos = 0;
    Button btnFibonacci;
    TextView txvMiTexto;

    String cadena = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txvMiTexto = findViewById(R.id.txv_main);
        btnFibonacci  = findViewById(R.id.btn_fibonacci);

        btnFibonacci.setOnClickListener(this);
        cadena += "| onCreate(saveInstantState)";
        txvMiTexto.setText(cadena);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        cadena += "| onCreate(saveInstant, persistentState)\n";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onStart() {
        super.onStart();

        cadena += "| onStart()\n";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onPause() {
        super.onPause();

        cadena += "| onPause()\n";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onStop() {
        super.onStop();

        cadena += "| onStop()\n";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        cadena += "| onDestroy()";
        txvMiTexto.setText(cadena);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        cadena += "| onRestart()";
        txvMiTexto.setText(cadena);
    }

    @Override
    public void onClick(View v) {

        fibonnacciUno = fibonnacciUno + fibonnacciDos;
        cadena = String.valueOf(fibonnacciUno);
        txvMiTexto.setText(cadena);
        fibonnacciDos = fibonnacciUno;

        //1,1,2,3,5,8
    }
}