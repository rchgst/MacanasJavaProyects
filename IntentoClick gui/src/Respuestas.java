import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Respuestas extends JPanel implements ActionListener {
    private JButton respuestita1;
    private JButton respuestita2;
    private JFrame jaja;

    public Respuestas(JFrame daddy){
        setLayout(new GridLayout(1,2));
        this.respuestita1=new JButton("SI PORFA Q RICO");
        respuestita1.setBackground(Color.MAGENTA);
        respuestita1.setForeground(Color.YELLOW);
        respuestita1.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        this.respuestita2=new JButton("MMM... no gracias!");
        respuestita2.setBackground(Color.BLACK);
        respuestita2.setForeground(Color.white);
        respuestita2.setFont(new Font("Impact", Font.PLAIN, 14));
        add(respuestita1);
        add(respuestita2);
        respuestita2.addActionListener(this);
        respuestita1.addActionListener(this);
    }
    public JButton getRespuestita2(){
        return this.respuestita2;
    }
    public void actionPerformed(ActionEvent e){
        new VentanaEmergente(this.jaja).setVisible(true);
    }
}
