import javax.swing.*;
import java.awt.*;

public class VentanaEmergente extends JDialog {
    public VentanaEmergente(JFrame vemtanaOriginal){
        super(vemtanaOriginal,"PUTITOOO",true);
        setSize(300, 150);
        setLocationRelativeTo(vemtanaOriginal);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.RED);
        JLabel etiqueta = new JLabel("TAS RE GARCHADITO jaja", SwingConstants.CENTER);
        etiqueta.setForeground(Color.YELLOW);
        etiqueta.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        add(etiqueta, BorderLayout.CENTER);
    }
}
