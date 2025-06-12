import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Calculadora extends JFrame implements KeyListener {
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

        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
        requestFocusInWindow();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int cod = e.getKeyCode();
        char tecla = e.getKeyChar();
        String tec = String.valueOf(tecla);

        switch (tec){
            case "0":
            case "1":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "2":
            case ".":
                panelResultado.addNum(String.valueOf(tecla));
                panelResultado.dibujaNum(String.valueOf(tecla));
                break;
            case "+":
            case "-":
            case "*":
            case "x":
            case "/":
                panelResultado.addOperando(String.valueOf(tecla));
                break;
            case "=":
            case "\n":
                if(panelResultado.validarPreCadena())
                    panelResultado.calcular(panelResultado.postCadena());
                break;
            case "(":
                panelResultado.addPar1();
                break;
            case ")":
                panelResultado.addPar2();
                break;
            case "^":
                panelResultado.addPot();
                panelResultado.dibujaPotencia();
                break;
        }
        switch (cod){
            case 8:
                panelResultado.rep();
                break;
            case 39:
                panelResultado.fin();
                panelResultado.dibujaFinDeOperacion();
                break;
        }
        panelResultado.mostrarLatex();
        panelResultado.mostrarPreCadena();
        if (tecla != '=' && !tec.equals("\n")) {
            panelResultado.setResultadoLabel(); // Solo actualiza vista mientras se arma la operación
        }
    }
}
