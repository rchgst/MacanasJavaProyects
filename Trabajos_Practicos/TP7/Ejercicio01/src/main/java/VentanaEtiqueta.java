import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEtiqueta extends JFrame {
  // atributo de instancia
  JLabel etiqueta;

  // Constructor
  public VentanaEtiqueta(String tit) {
    super(tit);
    setSize(400, 300);
    etiqueta = new JLabel();
    etiqueta.setText("Cafe");
    etiqueta.setIcon(new ImageIcon(getClass().getResource("./resources/cafe.gif")));
    getContentPane().setBackground(Color.GREEN);
    getContentPane().add(etiqueta);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
}
