package com.epam.project.task02.parser;

public class Parser {

    private static final String REGEX_SPLIT = ";\\s+";

    private Parser(){
    }
    
    public static int getIntValue(String string) {
        return Integer.parseInt(string);
    }
    
    public static String[] getStringsPlaneParameters(String string) {
        return string.split(REGEX_SPLIT);
    }
}
