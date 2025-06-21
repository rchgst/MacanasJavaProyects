import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Dos_Bebidas extends JFrame {
  private JButton botonCafe, botonJugo;
  private JPanel inferior, superior, centro;
  private JLabel etiquetaCafe, etiquetaJugo, vecesCafeOprimido, vecesJugoOprimido;
  private int contCafe, contJugo;

  public GUI_Dos_Bebidas() {
    this.botonCafe = new JButton("Cafe");
    this.botonJugo = new JButton("Jugo");
    this.superior = new JPanel(new GridLayout(1, 2));
    this.inferior = new JPanel(new FlowLayout());
    this.centro = new JPanel(new FlowLayout());
    this.etiquetaCafe = new JLabel();
    this.etiquetaJugo = new JLabel();
    this.vecesCafeOprimido = new JLabel();
    this.vecesJugoOprimido = new JLabel();
    OyenteCafe oyenteCafe = new OyenteCafe();
    OyenteJugo oyenteJugo = new OyenteJugo();
    this.botonCafe.addActionListener(oyenteCafe);
    this.botonJugo.addActionListener(oyenteJugo);
    this.inferior.add(this.botonCafe);
    this.inferior.add(this.botonJugo);
    this.superior.add(this.etiquetaCafe);
    this.superior.add(this.etiquetaJugo);
    this.centro.add(this.vecesCafeOprimido);
    this.centro.add(this.vecesJugoOprimido);
    this.etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    this.etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
    this.vecesCafeOprimido.setText("Veces que el boton cafe fue presionado: " + this.contCafe);
    this.vecesJugoOprimido.setText("Veces que el boton jugo fue presionado: " + this.contJugo);
    setLayout(new GridLayout(3, 1));
    getContentPane().add(this.superior);
    getContentPane().add(this.centro);
    getContentPane().add(this.inferior);
    setSize(600, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  class OyenteCafe implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
      etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
      ++contCafe;
      vecesCafeOprimido.setText("Veces que el boton cafe fue presionado: " + contCafe);
    }
  }

  class OyenteJugo implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      etiquetaJugo.setIcon(new ImageIcon(getClass().getResource("./resources/Jugo.gif")));
      etiquetaCafe.setIcon(new ImageIcon(getClass().getResource("./resources/Circulo.gif")));
      ++contJugo;
      vecesJugoOprimido.setText("Veces que el boton jugo fue presionado: " + contJugo);
    }
  }
}
