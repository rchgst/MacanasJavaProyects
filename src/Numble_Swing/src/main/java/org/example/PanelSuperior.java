package org.example;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {
    private JLabel titulo;
    private JLabel intentos;

    public PanelSuperior(PanelNumeros panelNumeros) {
        setLayout(new BorderLayout());

        titulo = new JLabel("Numble - Adivina el número", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        intentos = new JLabel("Intentos restantes: 5", SwingConstants.CENTER);
        intentos.setFont(new Font("Arial", Font.PLAIN, 16));

        add(titulo, BorderLayout.NORTH);
        add(intentos, BorderLayout.SOUTH);

        panelNumeros.setPanelSuperior(this);
    }

    public void setIntentosRestantes(int n) {
        intentos.setText("Intentos restantes: " + n);
    }
}
