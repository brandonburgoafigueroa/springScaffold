package com.ucbcba.edu.bo;

import java.io.File;
import java.util.Scanner;

public class Screen {
    CommandsManager commandsManager;
    Scanner scanner;
    String input;
    public Screen()
    {
        commandsManager=new CommandsManager();
        scanner=new Scanner(System.in);
    }
    public void setup()
    {
        System.out.println("Ingrese la direccion de la carpeta donde se encuentran los modelos");
        System.out.println("(De preferencia si se encuentran en el package principal ya que \n los archivos que se generaran se guardaran en esta misma ruta)");
        input=scanner.nextLine();
        commandsManager.setPath(input);
        if (is_folder_valid())
        {
            System.out.println("Carpeta verificada");

        }
        else
        {
            System.out.println("Carpeta no encontrada o no es una carpeta, verifique");
        }
    }

    private boolean is_folder_valid() {
        File file = new File(commandsManager.getPath());
        return file.exists()&&file.isDirectory();
    }
}
