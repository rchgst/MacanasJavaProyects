import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MiFrame extends JFrame implements ActionListener {
  private JLabel metros;
  private JLabel kilometros;
  private JTextField entrada;
  private JTextField salida;
  private JButton boton;

  public MiFrame() {
    this.metros = new JLabel("Metros");
    this.entrada = new JTextField(20);
    this.kilometros = new JLabel("Kilometros");
    this.salida = new JTextField(20);
    this.boton = new JButton("Convertir");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    getContentPane().add(this.metros);
    getContentPane().add(this.entrada);
    getContentPane().add(this.kilometros);
    getContentPane().add(this.salida);
    getContentPane().add(this.boton);
    this.boton.addActionListener(this);
    setSize(350, 200);
  }

  // private void cambiarTexto() {
  // this.boton.setText("Listo!");
  // }

  @Override
  public void actionPerformed(ActionEvent e) {
    double metros;
    double kilometros;
    if (!(this.entrada.getText().isBlank()) && this.salida.getText().isBlank()) {
      metros = Double.parseDouble(this.entrada.getText());
      kilometros = metros / 1000;
      this.salida.setText(String.valueOf(kilometros));
    }
    if (!(this.salida.getText().isBlank()) && this.entrada.getText().isBlank()) {
      kilometros = Double.parseDouble(this.salida.getText());
      metros = kilometros * 1000;
      this.entrada.setText(String.valueOf(metros));
    }
  }

}
