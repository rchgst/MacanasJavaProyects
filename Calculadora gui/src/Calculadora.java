import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {
    private JTextField ingreso;
    private Teclado tecladoNum;

    public Calculadora(){
        super("CALCULADORA UWU");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350,350);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(207, 196, 215));
        this.ingreso=new JTextField();
        ingreso.setFont(new Font("Century Gothic", Font.BOLD, 24));
        ingreso.setBackground(new Color(192, 192, 211));
        ingreso.setForeground(Color.black);
        ingreso.setEditable(false);
        ingreso.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(ingreso,BorderLayout.NORTH);
        this.tecladoNum=new Teclado(ingreso);
        this.add(tecladoNum,BorderLayout.CENTER);
    }
}
