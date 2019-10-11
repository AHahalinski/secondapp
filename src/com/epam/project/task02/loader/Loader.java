package com.epam.project.task02.loader;

import com.epam.project.task02.creator.Creator;
import com.epam.project.task02.model.Plane;
import com.epam.project.task02.reader.Reader;
import com.epam.project.task02.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Loader {

    private static Logger logger = LogManager.getLogger(Loader.class.getName());

    private Loader() {
    }

    public static List<Plane> loadData(String pathData) {
        logger.info("Start loading data");
        Validator.isNotNull(pathData);
        List<String> dataFromFile = Reader.read(pathData);

        List<Plane> planes = new ArrayList<>();

        for (String str : dataFromFile) {
            if (Validator.isValidString(str)) {
                logger.debug("String is valid");
                Plane plane = new Creator().createPlane(str);
                planes.add(plane);
            }
        }
        logger.info("End loading data");
        return planes;
    }
}
