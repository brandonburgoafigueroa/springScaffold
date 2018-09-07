package com.ucbcba.edu.bo;

public class Directions {
    private String path;

    public String JavaFile;


    public String getPath() {
        return path;
    }

    public void setPath(String input) {
        path=input;
    }


    public void setup(String obj)
    {
        JavaFile=path+"\\"+obj+".java";
    }
}
