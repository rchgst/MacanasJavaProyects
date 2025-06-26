package biblioteca_app.presentacion.paneles;

import javax.swing.*;
import java.awt.*;

public class RegistroButtons extends JPanel {
    private JButton registrar;
    private JButton volver;

    public RegistroButtons(){
        registrar = new JButton("registrar");
        volver = new JButton("volver");

        setLayout(new GridLayout(1,2));

        add(registrar);
        add(volver);
    }

    public JButton getRegistrar() {
        return registrar;
    }

    public JButton getVolver() {
        return volver;
    }
}
