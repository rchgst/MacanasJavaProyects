package biblioteca_app.presentacion;

import biblioteca_app.controladores.UsuarioController;
import biblioteca_app.datos.UsuarioDAO;
import biblioteca_app.presentacion.paneles.PanelBotones;
import biblioteca_app.presentacion.paneles.PanelForms;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame {
    private PanelForms panelForms;
    private PanelBotones panelBotones;
    private UsuarioDAO usuarioDAO;
    private UsuarioController usuarioController;


    public LoginView(){
        setTitle("Login");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelForms = new PanelForms();
        panelBotones = new PanelBotones();
        usuarioDAO = new UsuarioDAO();

        usuarioController = new UsuarioController(usuarioDAO,panelForms);

        panelBotones.getEnviar().addActionListener(usuarioController);

        // Layout
        setLayout(new BorderLayout());
        add(panelForms, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setVisible(true);
    }
}
