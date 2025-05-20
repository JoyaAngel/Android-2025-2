package com.example.m5_01;

import java.util.HashMap;
import java.util.Map;

public class RecursiveFibonacci {
    private static Map<Integer, Long> cache = new HashMap<>();
    public static long calculate(int number) {
        if (number <= 1) return number;
        if (cache.containsKey(number)) return cache.get(number);
        long result = calculate(number - 1) + calculate(number - 2);
        cache.put(number, result);
        return result;
    }
}