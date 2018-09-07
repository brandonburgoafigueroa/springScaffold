package com.ucbcba.edu.bo;

import java.io.File;

public class Scaffold {
    public static boolean scaffold(String obj, Directions directions)
    {
        String path=directions.getPath()+"\\"+obj+".java";
        if (is_valid_file(path))
        {
            return true;
        }
        return false;
    }

    private static boolean is_valid_file(String path) {
        File file = new File(path);
        return file.exists()&&file.isFile();
    }
}
