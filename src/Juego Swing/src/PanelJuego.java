import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PanelJuego extends JPanel implements KeyListener {
    private int x,y;

    public PanelJuego(){
        setFocusable(true);             // estos dos metodos, le dan foco al panel para que reciba eventos de teclado
        requestFocusInWindow();
        x=100;
        y=100;
        addKeyListener(this);
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        setBackground(Color.WHITE);

        g.setColor(Color.blue);
        g.fillRect(x,y,50,50);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();

        if (tecla == KeyEvent.VK_RIGHT && x < getWidth() - 50) {
            x += 10;
        }
        if (tecla == KeyEvent.VK_LEFT && x > 0) {
            x -= 10;
        }
        if (tecla == KeyEvent.VK_DOWN && y < getHeight() - 50) {
            y += 10;
        }
        if (tecla == KeyEvent.VK_UP && y > 0) {
            y -= 10;
        }

        repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
