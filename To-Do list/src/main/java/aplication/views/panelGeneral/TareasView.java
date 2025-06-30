package aplication.views.panelGeneral;

import javax.swing.*;
import java.awt.*;

public class TareasView extends JPanel {
    private BotonPanel botonPanel;
    private TableroPanel tableroPanel;

    public TareasView(){
        setLayout(new GridLayout(2,1));

        botonPanel = new BotonPanel();
        tableroPanel = new TableroPanel();

        add(tableroPanel);
        add(botonPanel);
    }

}
