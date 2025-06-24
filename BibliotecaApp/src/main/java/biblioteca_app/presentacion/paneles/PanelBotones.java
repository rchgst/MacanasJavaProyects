package biblioteca_app.presentacion.paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBotones extends JPanel{
    private JButton enviar,registrarse;

    public PanelBotones(){
        enviar = new JButton("enviar");
        registrarse = new JButton("registrarse");
        setLayout(new GridLayout(1,2));
        add(enviar);
        add(registrarse);
    }

    public JButton getEnviar() {
        return enviar;
    }

    public JButton getRegistrarse() {
        return registrarse;
    }
}
