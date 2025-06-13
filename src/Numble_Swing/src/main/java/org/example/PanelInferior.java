package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInferior extends JPanel {
    public PanelInferior(PanelNumeros panelNumeros) {
        setLayout(new FlowLayout());

        JButton btnProbar = new JButton("Probar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnReiniciar = new JButton("Jugar de nuevo");

        btnProbar.addActionListener(e -> {
            panelNumeros.probar();
            panelNumeros.requestFocusInWindow();
        });

        btnBorrar.addActionListener(e -> {
            panelNumeros.borrar();
            panelNumeros.requestFocusInWindow();
        });

        btnReiniciar.addActionListener(e -> {
            panelNumeros.reiniciar();
            panelNumeros.requestFocusInWindow();
        });


        add(btnProbar);
        add(btnBorrar);
        add(btnReiniciar);

        panelNumeros.setPanelInferior(this);
    }
}
