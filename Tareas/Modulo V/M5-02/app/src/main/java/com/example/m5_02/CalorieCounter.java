package com.example.m5_02;

import java.util.ArrayList;
import java.util.List;

public class CalorieCounter {
    public static List<Integer> sumCalories(String input) {
        List<Integer> sums = new ArrayList<>();
        int runningSum = 0;
        for (String line : input.split("\\n")) {
            if (line.trim().isEmpty()) {
                sums.add(runningSum);
                runningSum = 0;
            } else {
                runningSum += Integer.parseInt(line.trim());
            }
        }
        if (runningSum > 0) sums.add(runningSum);
        return sums;
    }

    public static int maxCalories(List<Integer> sums) {
        int max = 0;
        for (int sum : sums) {
            if (sum > max) max = sum;
        }
        return max;
    }
}