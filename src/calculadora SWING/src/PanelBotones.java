import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

public class PanelBotones extends JPanel implements ActionListener {
    public JButton num1,num2,num3,num4,num5,num6,num7,num8,num9,num0,punto,igual,suma,resta,mult,div,r2,vacia,raiz,potencia;
    public JButton par1,par2,pi,e,sen,cos,tan,log,rep,fin;
    public PanelResultado panelResultado;

    public PanelBotones(PanelResultado panelResultado) {
        this.panelResultado = panelResultado;

        setLayout(new GridLayout(5, 6));

        num1 = new JButton("1");
        num2 = new JButton("2");
        num3 = new JButton("3");
        num4 = new JButton("4");
        num5 = new JButton("5");
        num6 = new JButton("6");
        num7 = new JButton("7");
        num8 = new JButton("8");
        num9 = new JButton("9");
        num0 = new JButton("0");
        punto = new JButton(".");
        igual = new JButton("=");
        suma = new JButton("+");
        resta = new JButton("-");
        mult = new JButton("x");
        div = new JButton("/");
        r2 = new JButton("\u221A2");
        vacia = new JButton("AC");
        raiz = new JButton("\u221A");
        potencia = new JButton("x\u207F");
        par1 = new JButton("(");
        par2 = new JButton(")");
        pi = new JButton("\u03C0");
        e = new JButton("e");
        sen = new JButton("sen(x)");
        cos = new JButton("cos(x)");
        tan = new JButton("tan(x)");
        log = new JButton("log(x)");
        rep = new JButton("\u2190");
        fin = new JButton("\u2192");

        num1.addActionListener(this);
        num2.addActionListener(this);
        num3.addActionListener(this);
        num4.addActionListener(this);
        num5.addActionListener(this);
        num6.addActionListener(this);
        num7.addActionListener(this);
        num8.addActionListener(this);
        num9.addActionListener(this);
        num0.addActionListener(this);
        punto.addActionListener(this);
        igual.addActionListener(this);
        resta.addActionListener(this);
        suma.addActionListener(this);
        mult.addActionListener(this);
        div.addActionListener(this);
        pi.addActionListener(this);
        vacia.addActionListener(this);
        raiz.addActionListener(this);
        potencia.addActionListener(this);
        par1.addActionListener(this);
        par2.addActionListener(this);
        r2.addActionListener(this);
        e.addActionListener(this);
        sen.addActionListener(this);
        cos.addActionListener(this);
        tan.addActionListener(this);
        log.addActionListener(this);
        rep.addActionListener(this);
        fin.addActionListener(this);

        add(par1);
        add(par2);
        add(r2);
        add(e);
        add(pi);
        add(vacia);
        add(num1);
        add(num2);
        add(num3);
        add(suma);
        add(raiz);
        add(potencia);
        add(num4);
        add(num5);
        add(num6);
        add(resta);
        add(sen);
        add(cos);
        add(num7);
        add(num8);
        add(num9);
        add(mult);
        add(tan);
        add(log);
        add(punto);
        add(num0);
        add(igual);
        add(div);
        add(rep);
        add(fin);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nomBoton = e.getActionCommand();

        switch (nomBoton){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":
                panelResultado.addNum(nomBoton);
                panelResultado.dibujaNum(nomBoton);
                break;
            case "+":
            case "-":
            case "x":
            case "/":
                panelResultado.addOperando(nomBoton);
                break;
            case "\u221A":
                panelResultado.addRaiz();
                panelResultado.dibujaRaiz();
                break;
            case "x\u207F":
                panelResultado.addPot();
                panelResultado.dibujaPotencia();
                break;
            case "sen(x)":
                panelResultado.addSen();
                break;
            case "cos(x)":
                panelResultado.addCos();
                break;
            case "tan(x)":
                panelResultado.addTan();
                break;
            case "log(x)":
                panelResultado.addLog();
                break;
            case "\u221A2":
                panelResultado.raiz2();
                break;
            case "AC":
                panelResultado.vacia();
                break;
            case "(":
                panelResultado.addPar1();
                break;
            case ")":
                panelResultado.addPar2();
                break;
            case "\u2192":
                panelResultado.fin();
                panelResultado.dibujaFinDeOperacion();
                break;
            case "\u2190":
                panelResultado.rep();
                break;
            case "\u03C0":
                panelResultado.addPI();
                break;
            case "e":
                panelResultado.addConstant();
                break;
            case "=":
                if(panelResultado.validarPreCadena())
                    panelResultado.calcular(panelResultado.postCadena());
        }
        // Al final del actionPerformed
        panelResultado.mostrarPreCadena();
        panelResultado.mostrarLatex();

        if (!nomBoton.equals("=")) {
            panelResultado.setResultadoLabel(); // Solo actualiza vista mientras se arma la operación
        }

        // → DEVOLVER FOCO AL FRAME ←
        SwingUtilities.getWindowAncestor(this).requestFocusInWindow();
    }
}
