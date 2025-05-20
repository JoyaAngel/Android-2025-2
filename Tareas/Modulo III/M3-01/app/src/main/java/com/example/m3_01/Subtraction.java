package com.example.m3_01;

public class Subtraction implements Operation {
    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 - operand2;
    }
}