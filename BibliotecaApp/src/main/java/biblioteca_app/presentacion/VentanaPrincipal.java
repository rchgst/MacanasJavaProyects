package biblioteca_app.presentacion;

import biblioteca_app.presentacion.paneles.LoginView;
import biblioteca_app.presentacion.paneles.RegistroView;
import biblioteca_app.presentacion.paneles.UsuarioView;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel contenedor;
    private LoginView loginPanel;
    private RegistroView registroView;
    private UsuarioView usuarioView;

    public VentanaPrincipal(){
        setTitle("Biblioteca Aplication");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        loginPanel = new LoginView(this);
        registroView = new RegistroView(this);
        usuarioView = new UsuarioView();

        contenedor.add(loginPanel,"login");
        contenedor.add(registroView,"registro");
        contenedor.add(usuarioView,"cliente");

        add(contenedor);
        cardLayout.show(contenedor,"login");

        setVisible(true);
    }

    public void mostarPanelRegistro(){
        cardLayout.show(contenedor,"registro");
    }

    public void mostrarPanelInicio(){
        cardLayout.show(contenedor,"login");
    }

    public void mostrarPanelUsuario(){
        cardLayout.show(contenedor,"cliente");
    }

    public LoginView getLoginPanel() {
        return loginPanel;
    }

    public RegistroView getRegistroView() {
        return registroView;
    }
}
