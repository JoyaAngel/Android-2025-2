package com.example.m3_01;

public class Calculator {
    public static double performOperation(double a, double b, Operation operation) {
        return operation.calculate(a, b);
    }
}
