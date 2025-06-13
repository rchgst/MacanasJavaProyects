package org.example;

import javax.swing.*;
import java.awt.*;

public class Numble extends JFrame {
    PanelNumeros panelNumeros;
    PanelSuperior panelSuperior;
    PanelInferior panelInferior;

    public Numble() {
        panelNumeros = new PanelNumeros();
        panelSuperior = new PanelSuperior(panelNumeros);
        panelInferior = new PanelInferior(panelNumeros);

        setSize(600, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(panelSuperior, BorderLayout.NORTH);
        add(panelNumeros, BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);

        setVisible(true);
    }
}