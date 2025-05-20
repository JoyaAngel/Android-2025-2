package com.example.m3_01;

public class Division implements Operation {
    @Override
    public double calculate(double operand1, double operand2) {
        if (operand2 == 0) return Double.NaN;
        return operand1 / operand2;
    }
}
