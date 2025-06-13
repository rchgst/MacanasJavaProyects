package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Controlador {
    private int fila,columna;
    private boolean estado;
    private JLabel[][] casillas;
    private int[] numero;
    private Random random = new Random();

    public Controlador(JLabel[][] casillas){
        this.casillas = casillas;
        fila = columna = 0;
        estado = true;
        numero = new int[5];
        for (int i=0;i<5;i++)
            numero[i] = random.nextInt(10);
    }

    public void sgtePos(){
        if(columna<5)
            ++columna;
    }

    public void nuevonum(){
        fila++;
        columna = 0;
    }

    public boolean finJuego(){
        return fila > 4;
    }

    public boolean analizaJugadaGanadora(){
        if(!finJuego()) {
            boolean band = true;
            int i = 0;
            while (band && i < 5) {
                String num = String.valueOf(numero[i]);
                if (!(casillas[fila][i].getText().equals(num))) {
                    columna = 6;
                    band = false;
                }
                i++;
            }
            return band;
        }
        return false;
    }

    public boolean digitoCorrecto(int f,int c){
        String n = String.valueOf(numero[c]);
        return casillas[f][c].getText().equals(n);
    }

    public boolean estaDigito(int f, int c) {
        String texto = casillas[f][c].getText();
        for (int i = 0; i < 5; i++) {
            if (texto.equals(String.valueOf(numero[i])) && !digitoCorrecto(f, c)) {
                return true;
            }
        }
        return false;
    }
    public boolean filaVacia(){
        if(!finJuego()&&columna>0) {
            for (int i = 0; i < 5; i++) {
                if (casillas[fila][i].getText().equals(""))
                    return true;
            }
        }
        if(columna == 0)
            return true;
        return false;
    }

    public void delete(){
        if(columna>0) {
            casillas[fila][columna - 1].setText("");
            --columna;
        }
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    public void muestraNum(){
        for(int i=0;i<5;i++)
            System.out.println(numero[i]);
    }

    public int[] frecuencia(){
        int[] frec = new int[10];
        for (int i = 0; i < 5; i++) {
            frec[numero[i]]++;
        }
        return frec;
    }

    public void pintaCasillaVerde(int f,int c){
        casillas[f][c].setBackground(Color.GREEN);
    }

    public void pintaCasillaGris(int f,int c){
        casillas[f][c].setBackground(Color.GRAY);
    }

    public void pintaCasillaamarillo(int f,int c){
        casillas[f][c].setBackground(Color.YELLOW);
    }

    public void pintaCasillas(){
        int[] frec = frecuencia();
        Color[] colores = new Color[5];

        for (int i = 0; i < 5; i++) {
            String texto = casillas[fila][i].getText();
            if (!texto.equals("")) {
                int valor = Integer.parseInt(texto);
                if (valor == numero[i]) {
                    colores[i] = Color.GREEN;
                    frec[valor]--; // ya usamos uno de esos dígitos
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            if (colores[i] == null) { // solo si no se marcó en verde
                String texto = casillas[fila][i].getText();
                if (!texto.equals("")) {
                    int valor = Integer.parseInt(texto);
                    if (frec[valor] > 0) {
                        colores[i] = Color.YELLOW;
                        frec[valor]--; // ya usamos uno
                    } else {
                        colores[i] = Color.GRAY;
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            casillas[fila][i].setBackground(colores[i]);
        }
    }
}
