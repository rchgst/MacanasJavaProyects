import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teclado extends JPanel implements ActionListener {
    private String ingreso;
    private JTextField pantalla;
    public Teclado(JTextField pantalla){
        this.ingreso="";
        this.pantalla=pantalla;
        setLayout(new GridLayout(4,4));
        setBackground(new Color(211, 199, 227));
        String[][] etiquetas={
                {"7","8","9","%"},
                {"4","5","6","x"},
                {"1","2","3","-"},
                {"0",".","=","+"}
        };
        for(int i=0;i<4;i++){
            for (int j=0;j<4;j++) {
                JButton botoncito = new JButton(etiquetas[i][j]);
                botoncito.setFont(new Font("Century Gothic", Font.BOLD, 18));
                botoncito.setFocusPainted(false);
                botoncito.setForeground(Color.DARK_GRAY);
                botoncito.setOpaque(true);

                if ("+x-%=".contains(etiquetas[i][j])) {
                    botoncito.setBackground(new Color(121, 131, 199)); // operador
                } else {
                    botoncito.setBackground(new Color(190, 188, 229)); // número
                }
                botoncito.addActionListener(this);
                add(botoncito);
            }
        }
    }
    public void actionPerformed(ActionEvent e){
        JButton botonPressed = (JButton)e.getSource();
        String textoBoton=botonPressed.getText();
        if(!textoBoton.equals("=")){
            this.ingreso+=textoBoton;
            pantalla.setText(ingreso);
        }
        else{ //operar, tengo que separa en 2 variables double el primer operando del segundo y en otra variable la operacion
            double op1,op2,rdo;
            char operacion;
            String[] tokens = ingreso.split("(?<=[+x%\\-])|(?=[+x%\\-])");
            op1=Double.parseDouble(tokens[0]);
            op2=Double.parseDouble(tokens[2]);
            operacion=tokens[1].charAt(0);
            switch (operacion){
                case '+':
                    pantalla.setText(""+(op1+op2));
                    break;
                case '-':
                    pantalla.setText(""+(op1-op2));
                    break;
                case 'x':
                    pantalla.setText(""+(op1*op2));
                    break;
                case '%':
                    if(op2!=0)
                        pantalla.setText(""+(op1/op2));
                    else
                        pantalla.setText("ERROR, DIVISION POR CERO");
            }
        }
    }

}
