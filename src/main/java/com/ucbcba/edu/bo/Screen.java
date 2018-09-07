package com.ucbcba.edu.bo;

import java.io.File;
import java.util.Scanner;

public class Screen {
    Directions directions;
    Scanner scanner;
    String input;
    public Screen()
    {
        directions =new Directions();
        scanner=new Scanner(System.in);
    }
    public void setup()
    {
        System.out.println("Ingrese la direccion de la carpeta donde se encuentran los modelos");
        System.out.println("(De preferencia si se encuentran en el package principal ya que \n los archivos que se generaran se guardaran en esta misma ruta)");
        input=scanner.nextLine();
        directions.setPath(input);
        if (is_folder_valid())
        {
            System.out.println("Carpeta verificada");
            init();
            start();
        }
        else
        {
            System.out.println("Carpeta no encontrada o no es una carpeta, verifique");
        }
    }

    private void start() {
        boolean state=true;
        while (state)
        {
            System.out.println("      ");
            System.out.println("      ");
            System.out.println("Ingrese el nombre de la clase");
            input=scanner.nextLine();
            if (input.equals("-q"))
            {
                state=false;
            }
            else
            {
                scaffold(input);
            }
        }
    }

    private void scaffold(String obj) {
        System.out.println("Creando CRUD.....");
        if (Scaffold.scaffold(obj, directions))
        {
            System.out.println("Archivos creados exitosamente");
        }
        else
        {
            System.out.println("Algo paso, no se completaron las tareas");
        }
    }

    private void init() {
        System.out.println("App iniciada, Puede detener todo el proceso ingresando (-)");
    }

    private boolean is_folder_valid() {
        File file = new File(directions.getPath());
        return file.exists()&&file.isDirectory();
    }
}
