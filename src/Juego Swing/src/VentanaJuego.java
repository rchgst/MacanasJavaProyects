import javax.swing.*;

public class VentanaJuego extends JFrame {
    PanelJuego panelJuego;


    public VentanaJuego(){
        setTitle("juego del cuadrado");
        setSize(600,400);
        setLocationRelativeTo(null);
        panelJuego = new PanelJuego();
        add(panelJuego);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
