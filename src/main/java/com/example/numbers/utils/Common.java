package com.example.numbers.utils;

public final class Common {

    /**
     * Generate a random integer between min and max.
     *
     * @param min The min value.
     * @param max The max value.
     * @return The random number.
     */
    public static int irand(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

}
