package aplication.views;

import aplication.views.panelGeneral.TareasView;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private TareasView tareasView;

    public VentanaPrincipal(){
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tareasView = new TareasView();
        add(tareasView);
        setVisible(true);
    }
}
