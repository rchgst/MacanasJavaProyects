package aplication.views.panelGeneral;

import javax.swing.*;
import java.awt.*;

public class TareaPanel extends JPanel {
    private JLabel titulo;
    private JButton verMas;

    public TareaPanel(){
        setLayout(new GridLayout(2,1));

        titulo = new JLabel("");
        verMas = new JButton("ver mas");

        add(titulo);
        add(verMas);
    }

    public JLabel getTitulo() {
        return titulo;
    }

    public void setTitulo(JLabel titulo) {
        this.titulo = titulo;
    }

    public JButton getVerMas() {
        return verMas;
    }
}
