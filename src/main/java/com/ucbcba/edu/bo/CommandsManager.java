package com.ucbcba.edu.bo;

public class CommandsManager {
    public String execute(String s) {
        switch (s)
        {
            case "--h":
                return helpMessage;
        }
        return "";
    }
    private String helpMessage="" +
            "   Scaffold Spring 1.0" +"\n"+
            "   --h (Muestra este mensaje de ayuda)" +"\n"+
            "   --d (Asigna la ubicacion donde se generaran las clases)";
}
