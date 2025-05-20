package com.example.m3_01;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testCalculator();
    }

    private void testCalculator() {
        double num1 = 10;
        double num2 = 5;

        performAndLog(num1, num2, new Addition(), "Suma");
        performAndLog(num1, num2, new Subtraction(), "Resta");
        performAndLog(num1, num2, new Multiplication(), "Multiplicación");
        performAndLog(num1, num2, new Division(), "División");

        performAndLog(10, 0, new Division(), "División por cero");
    }

    private void performAndLog(double a, double b, Operation operation, String tag) {
        double result = Calculator.performOperation(a, b, operation);
        if (Double.isNaN(result)) {
            Log.d("Calculator", tag + ": Resultado inválido (NaN)");
        } else {
            Log.d("Calculator", tag + ": " + result);
        }
    }
}