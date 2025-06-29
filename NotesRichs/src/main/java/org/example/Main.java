package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cuaderno cuaderno = new Cuaderno();
        cuaderno.crearCarpeta();
        cuaderno.creaArchivo("nota");
        File archivo = cuaderno.buscaArchivo("nota");
        cuaderno.leerNota(archivo);

    }
}