import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {
    private PanelBotones panelBotones;
    private PanelResultado panelResultado;

    public Calculadora(){
        setTitle("calculadora");
        setSize(600,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelResultado = new PanelResultado();
        panelResultado.setBackground(Color.WHITE);
        panelBotones = new PanelBotones(panelResultado);
        setLayout(new GridLayout(2,1));
        add(panelResultado);
        add(panelBotones);
        setVisible(true);

    }
}
