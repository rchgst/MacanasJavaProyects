import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Bebida extends JFrame {
  private JButton botonCafe, botonJugo;
  private JLabel etiqueta;

  public GUI_Bebida() {
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.etiqueta = new JLabel();
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    getContentPane().add(this.botonCafe);
    getContentPane().add(this.botonJugo);
    getContentPane().add(this.etiqueta);
    setLayout(new FlowLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 300);
  }

  class OyenteCafe implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
    }
  }

  class OyenteJugo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/Jugo.gif")));
    }
  }
}
