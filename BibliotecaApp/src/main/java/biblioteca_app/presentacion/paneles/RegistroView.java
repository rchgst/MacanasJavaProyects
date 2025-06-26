package biblioteca_app.presentacion.paneles;

import biblioteca_app.controladores.PanelController;
import biblioteca_app.datos.UsuarioDAO;
import biblioteca_app.presentacion.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;

public class RegistroView extends JPanel {
    private RegistroFields registroFields;
    private RegistroButtons registroButtons;
    private UsuarioDAO usuarioDAO;
    private PanelController usuarioController;
    private VentanaPrincipal ventana;

    public RegistroView(VentanaPrincipal ventana){
        this.ventana = ventana;

        registroFields = new RegistroFields();
        registroButtons = new RegistroButtons();
        usuarioDAO = new UsuarioDAO();

        usuarioController = new PanelController(usuarioDAO,ventana);

        registroButtons.getRegistrar().addActionListener(usuarioController);
        registroButtons.getVolver().addActionListener(usuarioController);

        setLayout(new GridLayout(2,1));
        add(registroFields);
        add(registroButtons);

        setVisible(true);
    }

    public RegistroFields getRegistroFields() {
        return registroFields;
    }

    public RegistroButtons getRegistroButtons() {
        return registroButtons;
    }
}
