package org.wizestack;

import org.wizestack.utils.PrimeNumberUtils;

import java.util.stream.IntStream;

public final class SumFirstPrimeNumbers {

    private SumFirstPrimeNumbers() {}

    public static long doComputeSum(final int numberOfPrimeNumberToAdd) {
        return IntStream.iterate(0, value -> value + 1)
                .filter(value -> PrimeNumberUtils.isPrime(value))
                .limit(numberOfPrimeNumberToAdd)
                .sum();
    }
}
