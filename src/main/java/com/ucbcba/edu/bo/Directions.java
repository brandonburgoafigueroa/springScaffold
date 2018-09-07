package com.ucbcba.edu.bo;

public class Directions {
    private String path;
    private String packg;

    public String JavaFile;


    public String getPath() {
        return path;
    }

    public void setPath(String input) {
        path=input;
    }

    public String getPackg() {
        return packg;
    }

    public void setPackg(String packg) {
        this.packg = packg;
    }

    public void setup(String obj)
    {
        JavaFile=path+"\\"+obj+".java";
    }
}
