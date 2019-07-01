package org.wizestack;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class SumFirstPrimeNumbersTest {

    public static class SingleTests {

        @Test(expected = IllegalArgumentException.class)
        public void thatNegativeBoundShouldThrowException() {
            assertThat(SumFirstPrimeNumbers.doComputeSum(-1), is(equalTo(0)));
        }

    }

    @RunWith(Parameterized.class)
    public static class ParametrizedTests {
        private final int numberOfPrimeNumberToAdd;
        private final long expectedSum;

        public ParametrizedTests(final int numberOfPrimeNumberToAdd, final long expectedSum) {
            this.numberOfPrimeNumberToAdd = numberOfPrimeNumberToAdd;
            this.expectedSum = expectedSum;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(
                    new Object[] {0, 0L},
                    new Object[] {2, 5L},
                    new Object[] {3, 10L},
                    new Object[] {4, 17L}
            );
        }

        @Test
        public void thatComputedSumShouldReturnExpectedResults() {
            assertThat(SumFirstPrimeNumbers.doComputeSum(numberOfPrimeNumberToAdd), is(equalTo(expectedSum)));
        }
    }
}