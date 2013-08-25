package com.denarced.findinterval;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class IntervalTest {
    @Test
    public void baseTest() {
        // SETUP SUT
        List<Interval> input = Arrays.asList(
            new Interval(0, 20),
            new Interval(15, 40),
            new Interval(25, 50));

        // EXERCISE
        Set<Interval> overlaps = Interval.getOverlap(input);

        // VERIFY
        Set<Interval> expected = new HashSet<Interval>();
        expected.add(new Interval(15, 20));
        expected.add(new Interval(25, 40));
        Assert.assertEquals(expected, overlaps);
    }

    @Test
    public void allOverlapsTest() {
        // SETUP SUT
        List<Interval> input = Arrays.asList(
            new Interval(0, 1),
            new Interval(0, 1));

        // EXERCISE
        Set<Interval> overlaps = Interval.getOverlap(input);

        // VERIFY
        Set<Interval> expected = Collections.singleton(new Interval(0, 1));
        Assert.assertEquals(expected, overlaps);
    }

    @Test
    public void emptyInputTest() {
        // EXERCISE
        Set<Interval> overlaps = Interval.getOverlap(new LinkedList<Interval>());

        // VERIFY
        Assert.assertTrue(overlaps.isEmpty());
    }

    @Test
    public void sameStartTest() {
        // SETUP SUT
        List<Interval> input = Arrays.asList(
            new Interval(2, 5),
            new Interval(2, 4));

        // EXERCISE
        Set<Interval> overlaps = Interval.getOverlap(input);

        // VERIFY
        Set<Interval> expected = Collections.singleton(new Interval(2, 4));
        Assert.assertEquals(expected, overlaps);
    }

    @Test
    public void checkForOffByOneTest() {
        // SETUP SUT
        List<Interval> input = Arrays.asList(
            new Interval(0, 1),
            new Interval(1, 2));

        // EXERCISE
        Set<Interval> overlaps = Interval.getOverlap(input);

        // VERIFY
        Assert.assertTrue(overlaps.isEmpty());
    }

    @Test
    public void oneOverlappingValueTest() {
        // SETUP SUT
        List<Interval> input = Arrays.asList(
            new Interval(0, 2),
            new Interval(1, 3));

        // EXERCISE
        Set<Interval> overlaps = Interval.getOverlap(input);

        // VERIFY
        Assert.assertEquals(Collections.singleton(new Interval(1, 2)), overlaps);
    }

    @Test
    public void noOverlapTest() {
        // SETUP SUT
        List<Interval> input = Arrays.asList(
            new Interval(0, 1),
            new Interval(2, 3));

        // EXERCISE
        Set<Interval> overlaps = Interval.getOverlap(input);

        // VERIFY
        Assert.assertTrue(overlaps.isEmpty());
    }

    @Test
    public void singleItemInputTest() {
        // EXERCISE
        Set<Interval> overlaps = Interval.getOverlap(Collections.singletonList(new Interval(0, 10)));

        // VERIFY
        Assert.assertTrue(overlaps.isEmpty());
    }
}