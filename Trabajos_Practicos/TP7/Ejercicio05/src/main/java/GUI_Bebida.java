import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Bebida extends JFrame {
  private JButton botonCafe, botonJugo;
  private JLabel etiqueta;
  private JPanel superior, inferior;

  public GUI_Bebida() {
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.etiqueta = new JLabel();
    this.superior = new JPanel(new FlowLayout());
    this.inferior = new JPanel();
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    this.superior.add(this.etiqueta);
    this.superior.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.inferior.add(this.botonCafe);
    this.inferior.add(this.botonJugo);
    this.inferior.setBorder(BorderFactory.createLineBorder(Color.RED));
    this.inferior.setBackground(Color.GRAY);
    getContentPane().add(BorderLayout.CENTER, this.superior);
    getContentPane().add(BorderLayout.SOUTH, this.inferior);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 300);
  }

  class OyenteCafe implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
      superior.setBackground(Color.YELLOW);
    }
  }

  class OyenteJugo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/Jugo.gif")));
      superior.setBackground(Color.CYAN);
    }
  }
}
