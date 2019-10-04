package com.epam.project.tas02.comparator;

import com.epam.project.tas02.exception.ObjectNotExistHandlerException;
import com.epam.project.tas02.model.Plane;
import com.epam.project.tas02.validator.ValidatorNull;

import java.util.Comparator;

public class ComparatorPlaneMaxDistance implements Comparator<Plane> {
    @Override
    public int compare(Plane o1, Plane o2) throws ObjectNotExistHandlerException {
        ValidatorNull.isNotNull(o1, o2);
        return Integer.compare(o1.getMaxDistance(), o2.getMaxDistance());
    }
}
