package com.epam.project.tas02.loader;

import com.epam.project.tas02.creator.Creator;
import com.epam.project.tas02.exception.FileNotExistHandlerException;
import com.epam.project.tas02.model.Plane;
import com.epam.project.tas02.reader.Reader;
import com.epam.project.tas02.validator.Validator;

import java.util.ArrayList;
import java.util.List;

public class Loader {

    private static final String PATH = "resources/airlineData.txt";

    public static List<Plane> loadData() {
        List<String> dataFromFile = null;

        try {
            dataFromFile = Reader.read(PATH);
        } catch (FileNotExistHandlerException e) {
            e.printStackTrace();
        }

        List<Plane> planes = new ArrayList<>();

        for (String str: dataFromFile) {
            if(Validator.isValid(str)) {
                Plane plane = Creator.getPlane(str);
                planes.add(plane);
            }
        }
        return planes;
    }
}
