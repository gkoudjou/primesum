package org.wizestack.utils;

import java.util.stream.IntStream;

public class PrimeNumberUtils {

    public static boolean isPrime(final int numberToCheckPrimacy) {

        if(numberToCheckPrimacy < 0)
            throw new IllegalArgumentException("Cannot be null");

        if(numberToCheckPrimacy <= 1)
            return false;

        return IntStream
                .range(2, numberToCheckPrimacy / 2 + 1)
                .filter(value -> (numberToCheckPrimacy % value) == 0)
                .count() == 0L;
    }
}
