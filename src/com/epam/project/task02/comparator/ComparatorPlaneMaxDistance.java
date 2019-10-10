package com.epam.project.task02.comparator;

import com.epam.project.task02.model.Plane;

import java.util.Comparator;

public class ComparatorPlaneMaxDistance implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        return Integer.compare(o1.getMaxDistance(), o2.getMaxDistance());
    }
}
