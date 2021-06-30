package com.sdargol.util;

public class DirectoryUtil {
    private static final String MAIN_DIR = System.getProperty("user.dir");

    public static String getMainDir(){
        return MAIN_DIR;
    }
}
