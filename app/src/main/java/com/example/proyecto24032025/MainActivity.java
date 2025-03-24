package com.example.proyecto24032025;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnAgregaLeft;
    Button btnAgregaRight;
    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregaLeft = findViewById(R.id.btnAgregaLeft);
        btnAgregaRight = findViewById(R.id.btnAgregaRight);

        final int[] contador = {1};
        btnAgregaLeft.setOnClickListener(v -> {
            root = findViewById(R.id.lytLeft);
            generaBoton(contador[0]);
            contador[0]++;
        });

        btnAgregaRight.setOnClickListener(v -> {
            root = findViewById(R.id.lytRight);
            generaBoton(contador[0]);
            contador[0]++;
        });

    }

    void generaBoton(int contador){

        LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);
        Button btn = new Button(this);

        btn.setText(String.valueOf(contador));
        btn.setMinimumWidth(100);
        btn.setMinimumWidth(MATCH_PARENT);

        lytItemPrueba.setGravity(Gravity.CENTER);
        lytItemPrueba.addView(btn);

        root.addView(lytItemPrueba);
        lytItemPrueba.setMinimumWidth(MATCH_PARENT);
        lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.pink, getTheme()));

        btn.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), String.valueOf(contador), Toast.LENGTH_SHORT).show();
        });

        /*
        //Se genera el inflado de vista
        LinearLayout lytItemPrueba = (LinearLayout) LinearLayout.inflate(this, R.layout.item_prueba, null);
        ImageView img = new ImageView(this);

        //Se genera la imagen
        img.setImageResource(R.mipmap.ic_launcher);
        img.setMinimumHeight(100);
        img.setMinimumWidth(MATCH_PARENT);


        //Se agrega la imagen al layout inflado
        lytItemPrueba.setGravity(Gravity.CENTER);
        lytItemPrueba.addView(img);

        //Se agrega el layout inflado a la vista root
        root.addView(lytItemPrueba);
        lytItemPrueba.setMinimumWidth(MATCH_PARENT);
        lytItemPrueba.setBackgroundColor(getResources().getColor(R.color.pink, getTheme()));
        */

    }
}