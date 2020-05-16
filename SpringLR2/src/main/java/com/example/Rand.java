package com.example;

import java.util.Random;

public class    Rand {

    public String generatePassword(int passwordLength) {
        String result = new String();

        for (int i = 0; i < passwordLength; i++) {

            result += randomInt2String(0, 1);
        }
        return result;
    }

    public String randomInt2String(int minValue, int maxValue) {
        int diff = maxValue - minValue;
        java.util.Random random = new java.util.Random();
        String result = String.valueOf(random.nextInt(diff + 1) + minValue);
        return result;
    }
}

