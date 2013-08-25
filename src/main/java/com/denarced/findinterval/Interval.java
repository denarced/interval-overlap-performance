package com.denarced.findinterval;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Interval {
    private final int start;
    private final int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
    public static Set<Interval> getOverlap(List<Interval> intervalList) {
        if (intervalList == null) {
            throw new NullPointerException("Input list cannot be null.");
        }

        final HashSet<Interval> hashSet = new HashSet<Interval>();

        for (int i = 0; i < intervalList.size() - 1; i++) {
            final Interval intervali =  intervalList.get(i);

            for (int j = i; j < intervalList.size(); j++) {
                final Interval intervalj = intervalList.get(j);

                if (intervalj.getStart() < intervali.getEnd() &&
                    intervalj.getEnd() > intervali.getStart() &&
                    i != j) {

                    hashSet.add(
                        new Interval(
                            Math.max(intervali.getStart(), intervalj.getStart()),
                            Math.min(intervali.getEnd(), intervalj.getEnd())
                        )
                    );
                }
            }
        }

        return hashSet;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Interval (" + start + "," + end + ").";
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 17 + start;
        return hash * 31 + end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Interval) {
            Interval rhs = (Interval) o;
            return start == rhs.start &&
                end == rhs.end;
        }
        return false;
    }
}