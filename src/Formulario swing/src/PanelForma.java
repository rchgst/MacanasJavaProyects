import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelForma extends JPanel implements ActionListener {
    JLabel nombreLabel,edadLabel,emailLabel,contraLabel,validacion;
    JTextField nombreText,emailText,edadText,contraText;
    JButton enviar;

    public PanelForma(){
        setLayout(new GridLayout(6,2,10,10));
        setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        nombreLabel = new JLabel("nombre de usuario:");
        edadLabel = new JLabel("edad: ");
        emailLabel = new JLabel("email:");
        contraLabel = new JLabel("contraseña:");
        nombreText = new JTextField();
        edadText = new JTextField();
        emailText = new JTextField();
        contraText = new JTextField();
        enviar = new JButton("enviar");
        validacion = new JLabel("");

        enviar.addActionListener(this);

        add(nombreLabel);
        add(nombreText);
        add(edadLabel);
        add(edadText);
        add(emailLabel);
        add(emailText);
        add(contraLabel);
        add(contraText);
        add(enviar);
        add(new JLabel(""));
        add(validacion);
        add(new JLabel(""));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = nombreText.getText();
        String email = emailText.getText();
        int edad = Integer.parseInt(edadText.getText());
        String contraseña = contraText.getText();

        boolean verificaEmail = email.contains("@gmail.com")||email.contains("@hotmail.com");
        boolean verificaEdad = edad >= 18;
        boolean verificaContraseña = contraseña.length()>7;

        if(verificaEmail && verificaEdad && verificaContraseña)
            validacion.setText("datos correctos, bienvenido "+nombre);
        else{
            String mensaje = "";
            if(!verificaEmail)
                mensaje+=", email incorrecto";
            if(!verificaEdad)
                mensaje+=", no eres mayor de edad";
            if(!verificaContraseña)
                mensaje+=", contraseña invalida";
            validacion.setText("error al registrar"+mensaje);
        }

    }
}
