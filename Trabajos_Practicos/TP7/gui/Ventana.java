// package gui;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Ventana extends JFrame {
  private JRadioButton radio1;
  private JRadioButton radio2;
  private ButtonGroup grupo;

  public Ventana() {
    super();
    initGui();
  }

  private void initGui() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    getContentPane().setLayout(null);
    this.setPreferredSize(new Dimension(209, 103));
    // crea y agrega el primer radioButton
    radio1 = new JRadioButton();
    getContentPane().add(radio1);
    radio1.setText("Opcion 1");
    radio1.setBounds(12, 10, 178, 18);
    // crea y agrega el segundo radioButton
    radio2 = new JRadioButton();
    getContentPane().add(radio2);
    radio2.setText("Opcion 2");
    radio2.setBounds(12, 35, 178, 18);
    // crea un grupo para los radioButton
    // grupo = new ButtonGroup();
    // grupo.add(radio1);
    // grupo.add(radio2);

    pack();
  }
}
