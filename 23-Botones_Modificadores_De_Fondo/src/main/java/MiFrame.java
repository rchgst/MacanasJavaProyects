import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiFrame extends JFrame {
  private JButton verde, rojo;
  private JPanel panelBotones, panelColor;

  public MiFrame() {
    this.rojo = new JButton("Rojo");
    this.verde = new JButton("Verde");
    this.panelColor = new JPanel();
    this.panelBotones = new JPanel(new FlowLayout());
    OyenteRojo oyenteRojo = new OyenteRojo();
    OyenteVerde oyenteVerde = new OyenteVerde();
    this.rojo.addActionListener(oyenteRojo);
    this.verde.addActionListener(oyenteVerde);
    this.panelBotones.add(this.rojo);
    this.panelBotones.add(this.verde);
    getContentPane().add(this.panelBotones);
    getContentPane().add(this.panelColor);
    setLayout(new GridLayout(1, 2));
    setSize(500, 300);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  class OyenteRojo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      panelColor.setBackground(Color.RED);
    }
  }

  class OyenteVerde implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      panelColor.setBackground(Color.GREEN);
    }
  }
}
