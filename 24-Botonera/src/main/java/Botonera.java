import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Botonera extends JFrame {
  private JPanel panelBotones;
  private JButton[] botones;

  public Botonera() {
    setSize(400, 200);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.panelBotones = new JPanel();
    this.botones = new JButton[5];
    armarBotonera();
    getContentPane().add(this.panelBotones);
  }

  private void armarBotonera() {
    Oyente oyente = new Oyente();
    for (int i = 0; i < 5; i++) {
      this.botones[i] = new JButton("" + i);
      this.botones[i].setBackground(Color.WHITE);
      this.botones[i].addActionListener(oyente);
      this.panelBotones.add(this.botones[i]);
    }
  }

  private class Oyente implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      JButton b = (JButton) e.getSource();
      if (b.getBackground().equals(Color.RED)) {
        int i = 0;
        while (!(botones[i].equals(b))) {
          ++i;
        }
        b.setBackground(Color.WHITE);
        b.setText("" + i);
      } else {
        b.setBackground(Color.RED);
        b.setText("OK");
      }
    }

  }
}
