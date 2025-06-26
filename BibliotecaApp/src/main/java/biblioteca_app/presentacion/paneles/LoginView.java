package biblioteca_app.presentacion.paneles;

import biblioteca_app.controladores.PanelController;
import biblioteca_app.datos.UsuarioDAO;
import biblioteca_app.presentacion.VentanaPrincipal;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {
    private PanelForms panelForms;
    private PanelBotones panelBotones;
    private UsuarioDAO usuarioDAO;
    private PanelController usuarioController;
    private VentanaPrincipal ventana;

    public LoginView(VentanaPrincipal ventana){
        this.ventana = ventana;

        panelForms = new PanelForms();
        panelBotones = new PanelBotones();
        usuarioDAO = new UsuarioDAO();

        usuarioController = new PanelController(usuarioDAO,ventana);

        panelBotones.getEnviar().addActionListener(usuarioController);
        panelBotones.getRegistrarse().addActionListener(usuarioController);

        // Layout
        setLayout(new GridLayout(2,1));
        add(panelForms);
        add(panelBotones);

        setVisible(true);
    }

    public PanelForms getPanelForms() {
        return panelForms;
    }

    public PanelBotones getPanelBotones() {
        return panelBotones;
    }
}
