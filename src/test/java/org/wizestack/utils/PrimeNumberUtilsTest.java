package org.wizestack.utils;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeNumberUtilsTest {

    public static final int BOUND = 1000;

    @Test
    public void thatEvenNumberAreNotPrime() {
        int randomEvenNumber = ThreadLocalRandom.current().nextInt(2, BOUND) * 2;
        assertThat(PrimeNumberUtils.isPrime(randomEvenNumber), is(false));
    }

    @Test
    public void thatSomeKnownOddNumbersAreNotPrime() {
        IntStream.of(21, 25, 33).forEach(value -> assertThat(PrimeNumberUtils.isPrime(value), is(false)));
    }

    @Test
    public void thatSomeKnownOddNumbersArePrime() {
        IntStream.of(3, 5, 7, 11, 13, 17).forEach(value -> assertThat(PrimeNumberUtils.isPrime(value), is(true)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void thatNegativeNumberAreNotPrime() {
        int randomNegativeNumber = new Random().nextInt(BOUND) * -1;
        assertThat(PrimeNumberUtils.isPrime(randomNegativeNumber), is (false));
    }

    @Test
    public void thatZeroIsNotPrime() {
        assertThat(PrimeNumberUtils.isPrime(0), is(false));
    }

    @Test
    public void thatOneIsNotPrime() {
        assertThat(PrimeNumberUtils.isPrime(1), is(false));
    }

    @Test
    public void thatTwoIsPrime() {
        assertThat(PrimeNumberUtils.isPrime(2), is(true));
    }
}
