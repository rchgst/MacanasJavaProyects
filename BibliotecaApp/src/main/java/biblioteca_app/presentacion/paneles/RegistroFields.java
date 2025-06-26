package biblioteca_app.presentacion.paneles;

import javax.swing.*;
import java.awt.*;

public class RegistroFields extends JPanel {
    private JTextField nombre;
    private JTextField dni;
    private JTextField email;
    private JTextField password;
    private JLabel textNombre;
    private JLabel textDni;
    private JLabel textEmail;
    private JLabel textPassword;

    public RegistroFields (){
        setLayout(new GridLayout(4,2));

        nombre = new JTextField();
        dni = new JTextField();
        email = new JTextField();
        password = new JTextField();
        textNombre = new JLabel("nombre completo:");
        textDni = new JLabel("DNI:");
        textEmail = new JLabel("email:");
        textPassword = new JLabel("contraseña:");

        add(textNombre);
        add(nombre);
        add(textDni);
        add(dni);
        add(textEmail);
        add(email);
        add(textPassword);
        add(password);
    }

    public JTextField getNombre() {
        return nombre;
    }

    public JTextField getDni() {
        return dni;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getPassword() {
        return password;
    }
}
