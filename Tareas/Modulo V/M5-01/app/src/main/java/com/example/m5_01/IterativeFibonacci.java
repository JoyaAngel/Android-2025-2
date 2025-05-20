package com.example.m5_01;

public class IterativeFibonacci {
    public static long calculate(int number) {
        if (number <= 1) return number;
        long previous = 0, current = 1, next;
        for (int counter = 2; counter <= number; counter++) {
            next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}