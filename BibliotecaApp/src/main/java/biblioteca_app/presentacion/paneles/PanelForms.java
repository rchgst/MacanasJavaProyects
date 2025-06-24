package biblioteca_app.presentacion.paneles;

import javax.swing.*;
import java.awt.*;

public class PanelForms extends JPanel {
    private JTextField email,password;

    public PanelForms(){
        setLayout(new GridLayout(2,1));

        email = new JTextField();
        password = new JTextField();

        add(email);
        add(password);
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getPassword() {
        return password;
    }
}
