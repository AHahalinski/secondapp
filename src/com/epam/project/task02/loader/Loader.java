package com.epam.project.task02.loader;

import com.epam.project.task02.creator.Creator;
import com.epam.project.task02.model.Plane;
import com.epam.project.task02.reader.Reader;
import com.epam.project.task02.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static List<Plane> loadData(String pathData) {
        Validator.isNotNullArgument(pathData);
        List<String> dataFromFile = Reader.read(pathData);

        List<Plane> planes = new ArrayList<>();

        for (String str : dataFromFile) {
            if (Validator.isValidString(str)) {
                Plane plane = new Creator().createPlane(str);
                planes.add(plane);
            }
        }
        return planes;
    }
}
