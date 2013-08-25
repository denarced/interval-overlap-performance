package com.denarced.findinterval;

import org.junit.Test;

import java.util.*;

public class IntervalPerformanceTest {
    private static int alpha = 5;

    private List<Interval> getInput() {
        final int size = 10000;
        List<Interval> input = new ArrayList<Interval>(size);
        final int length = 10;
        for (int i = 0; i < size; ++i) {
            Interval interval = new Interval(alpha, alpha + length);
            input.add(interval);
            alpha += (length / 2);
        }

        return input;
    }

    @Test
    public void performanceTest() {
        // WARM UP
        final int warmup = 10;
        for (int i = 0; i < warmup; ++i) {
            testDuration(getInput());
        }

        // EXERCISE
        final int rounds = 100;
        TreeSet<Long> durations = new TreeSet<Long>();
        for (int i = 0; i < rounds; ++i) {
            List<Interval> input = getInput();
            durations.add(testDuration(input));
        }

        System.out.println("Minimum: " + durations.first());
        System.out.println("Maximum: " + durations.last());
        System.out.println("Average: " + average(durations));
    }

    private long testDuration(List<Interval> input) {
        long alpha = System.currentTimeMillis();
        Interval.getOverlap(input);
        long omega = System.currentTimeMillis();

        return omega - alpha;
    }

    private int average(Set<Long> durations) {
        long sum = 0;
        for (Long each: durations) {
            sum += each;
        }
        return (int) (sum / (long) durations.size());
    }
}
