import javax.swing.*;
import java.awt.*;

public class VentanaEtiqueta extends JFrame {
	// atributo de instancia
	JLabel etiqueta;

	// Constructor
	public VentanaEtiqueta(String tit) {
		super(tit);
		setSize(400, 300);
		etiqueta = new JLabel();
		etiqueta.setText("Sam");
		etiqueta.setIcon(new ImageIcon(getClass().getResource("perro.jpg")));
		getContentPane().setBackground(Color.GREEN);
		getContentPane().add(etiqueta);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}