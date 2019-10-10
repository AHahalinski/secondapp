package com.epam.project.task02.comparator;

import com.epam.project.task02.model.Plane;

import java.util.Comparator;

public class ComparatorPlaneType implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        return o1.getType().compareTo(o2.getType());
    }
}
