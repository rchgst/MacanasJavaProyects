package biblioteca_app.presentacion.paneles;

import javax.swing.*;
import java.awt.*;

public class PanelForms extends JPanel {
    private JTextField email;
    private JTextField password;
    private JLabel labelEmail,labelPassword;

    public PanelForms(){
        setLayout(new GridLayout(2,2));

        email = new JTextField();
        password = new JTextField();
        labelEmail = new JLabel("email:");
        labelPassword = new JLabel("password:");

        add(labelEmail);
        add(email);
        add(labelPassword);
        add(password);
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getPassword() {
        return password;
    }
}
