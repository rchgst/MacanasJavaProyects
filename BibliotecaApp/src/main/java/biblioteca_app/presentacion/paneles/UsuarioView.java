package biblioteca_app.presentacion.paneles;

import biblioteca_app.dominio.Usuario;

import javax.swing.*;
import java.awt.*;

public class UsuarioView extends JPanel {
    private JLabel saludo;

    public UsuarioView(){
        saludo = new JLabel("hola bienvenido");

        setLayout(new GridLayout(1,1));

        add(saludo);

        setVisible(true);
    }

}
