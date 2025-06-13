package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelNumeros extends JPanel implements KeyListener {
    private JLabel[][] casillas;
    private Controlador controlador;
    private int estado; // -1 perdido, 0 en juego, 1 ganado
    private PanelSuperior panelSuperior;
    private PanelInferior panelInferior;

    public PanelNumeros() {
        setLayout(new GridLayout(5, 5));
        casillas = new JLabel[5][5];
        controlador = new Controlador(casillas);
        estado = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                casillas[i][j] = new JLabel("", SwingConstants.CENTER);
                casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                casillas[i][j].setFont(new Font("Monospaced", Font.BOLD, 24));
                casillas[i][j].setOpaque(true);
                add(casillas[i][j]);
            }
        }

        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    public void setPanelSuperior(PanelSuperior panelSuperior) {
        this.panelSuperior = panelSuperior;
    }

    public void setPanelInferior(PanelInferior panelInferior) {
        this.panelInferior = panelInferior;
    }

    public void probar() {
        if (!controlador.finJuego()) {
            if (!controlador.filaVacia()) {
                if (controlador.analizaJugadaGanadora()) {
                    JOptionPane.showMessageDialog(this, "¡Ganaste!");
                    estado = 1;
                }
                controlador.pintaCasillas();
                controlador.nuevonum();
                updateIntentosRestantes();
            }
        }
        if (estado != 1 && controlador.finJuego()) {
            JOptionPane.showMessageDialog(this, "Perdiste. ¡Intentá de nuevo!");
            estado = -1;
        }
    }

    public void borrar() {
        controlador.delete();
    }

    public void reiniciar() {
        removeAll();
        controlador = new Controlador(casillas);
        estado = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                casillas[i][j].setText("");
                casillas[i][j].setBackground(null);
                add(casillas[i][j]);
            }
        }

        controlador.muestraNum();
        revalidate();
        repaint();
        requestFocusInWindow();

        updateIntentosRestantes();
    }

    public void updateIntentosRestantes() {
        if (panelSuperior != null) {
            int restantes = 5 - controlador.getFila();
            panelSuperior.setIntentosRestantes(restantes);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!controlador.finJuego()) {
            String tecla = String.valueOf(e.getKeyChar());

            if (tecla.length() == 1 && Character.isDigit(tecla.charAt(0))) {
                if (controlador.getColumna() >= 0 && controlador.getColumna() < 5) {
                    casillas[controlador.getFila()][controlador.getColumna()].setText(tecla);
                    controlador.sgtePos();
                }
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                probar();
            } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                borrar();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}