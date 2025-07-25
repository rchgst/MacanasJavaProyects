
package model;

import java.util.Arrays;

public class TablaGenerator {
    private int cantidadVariables;
    private int columnas;
    private int filas;
    private char[][] tabla;

    public TablaGenerator(int cantidadVariables){
        this.cantidadVariables = cantidadVariables;

        columnas = cantidadVariables;
        filas = (int) Math.pow(2,cantidadVariables);
        tabla = new char[filas][columnas];
    }

    public TablaGenerator(){
        cantidadVariables = columnas = 1;
        filas = 2;
        tabla = new char[1][2];
    }

    public String rellenaCeros(String bin,int cifras){
        StringBuilder sb = new StringBuilder(bin);
        while (sb.length()!=cifras)
            sb.insert(0,"0");
        return String.valueOf(sb);
    }

    public void generarTabla(){
        int unos = filas/2;
        String bin;
        int c;

        for (int i=0;i<filas/2;i++) {
            tabla[i][0] = '0';
            tabla[unos][0] = '1';
            if (cantidadVariables > 1) {
                bin = Integer.toBinaryString(i);
                bin = this.rellenaCeros(bin, cantidadVariables - 1);
                c = 0;
                for (int j = 1; j < cantidadVariables; j++) {
                    tabla[i][j] = bin.charAt(c);
                    tabla[unos][j] = bin.charAt(c);
                    c++;
                }
                unos++;
            }
        }
    }

    public char[][] getTabla() {
        return tabla;
    }

}
