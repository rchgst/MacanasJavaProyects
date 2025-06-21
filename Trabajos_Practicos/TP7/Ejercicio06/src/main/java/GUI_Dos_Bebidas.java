import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Dos_Bebidas extends JFrame {
  private JButton botonCafe, botonJugo;
  private JPanel inferior, superior;
  private JLabel etiquetaCafe, etiquetaJugo;

  public GUI_Dos_Bebidas() {
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.superior = new JPanel(new GridLayout(1, 2));
    this.inferior = new JPanel(new FlowLayout());
    this.etiquetaCafe = new JLabel();
    this.etiquetaJugo = new JLabel();
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    this.inferior.add(this.botonCafe);
    this.inferior.add(this.botonJugo);
    this.superior.add(this.etiquetaCafe);
    this.superior.add(this.etiquetaJugo);
    this.etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    this.etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    getContentPane().add(BorderLayout.SOUTH, this.inferior);
    getContentPane().add(BorderLayout.CENTER, this.superior);
    setSize(450, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  class OyenteCafe implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
      etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    }
  }

  class OyenteJugo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Jugo.gif")));
      etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    }
  }
}
