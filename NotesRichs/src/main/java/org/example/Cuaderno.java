package org.example;

import com.sun.jdi.request.StepRequest;

import java.io.*;
import java.util.ArrayList;

public class Cuaderno {
    private File carpeta;
    private ArrayList<File>notas;

    public Cuaderno(){
        carpeta = new File("notas");
        notas = new ArrayList<File>();
    }

    public void crearCarpeta(){
        if(!carpeta.exists())
            carpeta.mkdir();
        else
            System.out.println("la carpeta ya fue creada anteriormente");
    }

    public void creaArchivo(String nombre){
        File archivo = new File(carpeta,nombre+".txt");
        try {
            if(!archivo.exists()){
                PrintWriter writer = new PrintWriter(new FileWriter(archivo));
                notas.add(archivo);
            }
            else
                System.out.println("archivo existente");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public File buscaArchivo(String nombre){
        for(int i=0;i<notas.size();i++){
            if(notas.get(i).getName().equals(nombre))
                return notas.get(i);
        }
        return null;
    }

    public void leerNota(File file){
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(file));
            String linea = entrada.readLine();

            while (linea!=null) {
                System.out.println(linea);
                linea = entrada.readLine();
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

}
