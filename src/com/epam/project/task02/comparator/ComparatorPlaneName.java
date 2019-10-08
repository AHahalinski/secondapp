package com.epam.project.task02.comparator;

import com.epam.project.task02.model.Plane;
import com.epam.project.task02.validator.Validator;

import java.util.Comparator;

public class ComparatorPlaneName implements Comparator<Plane> {
    @Override
    public int compare(Plane o1, Plane o2){
        Validator.isNotNull(o1, o2);
        return o1.getBoardName().compareTo(o2.getBoardName());
    }
}
