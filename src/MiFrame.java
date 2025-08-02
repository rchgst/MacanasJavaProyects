import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiFrame extends JFrame {
    private JPanel panelBotones;
    private JButton []botones;

    public MiFrame(){
        setSize(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panelBotones=new JPanel();
        botones= new JButton[5];
        armarBotonera();
        getContentPane().add(panelBotones);
    }
    public void armarBotonera(){
        Oyente oyente;
        for (int i=0;i<5;i++){
            botones[i]=new JButton();
            botones[i].setText(""+i);
            botones[i].setBackground(Color.WHITE);
            oyente = new Oyente(i,botones[i]);
            botones[i].addActionListener(oyente);
            panelBotones.add(botones[i]);
        }
    }
    private class Oyente implements ActionListener{
        private int numOriginal;
        private JButton boton;
        public Oyente(int numOriginal,JButton boton){
            this.numOriginal=numOriginal;
            this.boton=boton;
        }
        public void actionPerformed(ActionEvent e){
            if(this.boton.getText().equals("OK")){
                boton.setText(""+numOriginal);
                boton.setBackground(Color.WHITE);
            }
            else{
                boton.setText("OK");
                boton.setBackground(Color.RED);
                boton.setBackground(Color.WHITE);
            }
        }
    }
}
