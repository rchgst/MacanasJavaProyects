import javax.swing.*;

public class Formulario extends JFrame {
    JPanel forms;


    public Formulario(String nombre){
        super(nombre);
        setSize(485,310);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        forms = new PanelForma();
        add(forms);
        setVisible(true);
    }



}
