import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Bebida extends JFrame {
  private JButton botonCafe, botonJugo;
  private JLabel etiqueta;
  private JPanel panel;

  public GUI_Bebida() {
    setLayout(new GridLayout(1, 2));
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(300, 300);
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.etiqueta = new JLabel();
    this.panel = new JPanel(new FlowLayout());
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    this.panel.add(this.botonCafe);
    this.panel.add(this.botonJugo);
    this.panel.add(this.etiqueta);
    getContentPane().add(this.panel);
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
