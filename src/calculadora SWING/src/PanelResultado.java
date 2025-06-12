import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class PanelResultado extends JPanel {
    private JLabel resultadoLabel;
    private String preCadena,evaluar,preLatex;
    private Icon operacion;

    public PanelResultado(){
        resultadoLabel = new JLabel("");
        resultadoLabel.setFont(new Font("Arial", Font.PLAIN,26));
        resultadoLabel.setPreferredSize(new Dimension(300, 50));
        setPreferredSize(new Dimension(320, 60));
        preCadena = evaluar = preLatex = "";
        add(resultadoLabel);
    }

    public void addOperando(String op){
        preCadena += "<"+op+">";
        preCadena = preCadena.replace("x","*");
        preLatex += op;
        preLatex = preLatex.replace("x","*");
    }

    public void addNum(String num){
        preCadena += num;
    }

    public boolean validarPreCadena(){
        return !preCadena.contains("><");
    }

    public void addRaiz(){
        preCadena+="sqrt(";
    }

    public void addPot(){
        preCadena+="^(";
    }

    public void addSen(){
        preCadena+="sin(";
        preLatex += "\\sin(";
    }

    public void addCos(){
        preCadena +="cos(";
        preLatex += "\\cos(";
    }

    public void addTan(){
        preCadena += "tan(";
        preLatex += "\\tan(";
    }

    public  void addLog(){
        preCadena += "log10(";
        preLatex += "\\log_{10}(";
    }

    public void addPI(){
        double pi = Math.PI;
        preCadena += pi;
        preLatex += pi;
    }

    public void addConstant(){
        double e = Math.E;
        preCadena += e;
        preLatex += e;
    }

    public void raiz2(){
        double res = Math.sqrt(2);
        preCadena += res;
        preLatex += res;
    }

    public void fin(){
        preCadena+=")";
    }

    public void rep(){
        preCadena = preCadena.substring(0,preCadena.length()-1);
        preLatex = preLatex.substring(0,preLatex.length()-1);
    }

    public void del(){
        String etiqueta = resultadoLabel.getText();
        resultadoLabel.setText(etiqueta.substring(0,etiqueta.length()-1));
        preCadena = preCadena.substring(0,preCadena.length()-1);
        preLatex = preLatex.substring(0,preLatex.length()-1);
    }

    public void vacia(){
        resultadoLabel.setText("");
        preCadena = "";
        preLatex = "";
    }

    public String postCadena(){
        if(validarPreCadena()){
            evaluar = preCadena.replace("<","");
            evaluar = evaluar.replace(">","");
        }
        return evaluar;
    }

    public void addPar1(){
        preCadena+="(";
        preLatex+="(";
    }

    public void addPar2(){
        preCadena+=")";
        preLatex+=")";
    }

    public void calcular(String evaluar){
        try {
            Expression expr = new ExpressionBuilder(evaluar).build();
            double result = expr.evaluate();
            String res = String.valueOf(result);

            TeXFormula  formula = new TeXFormula(res);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 20);

            resultadoLabel.setIcon(icon);
            resultadoLabel.setText("");
            resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            resultadoLabel.repaint();

        } catch (Exception e) {
            resultadoLabel.setIcon(null);
            resultadoLabel.setText("Error");
            System.out.println("Error al evaluar: " + e.getMessage());
        }
    }


    public void mostrarPreCadena(){
        System.out.println(preCadena);
    }

    // a partir de aqui se implementan los metodos que ayudan a ver los numeros y operaciones con latex

    public void mostrarLatex(){
        System.out.println(preLatex);
    }

    public void setResultadoLabel(){
        String exp = preLatex;
        TeXFormula formula = new TeXFormula(exp);
        TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY,20);
        resultadoLabel.setIcon(icon);
    }

    public void dibujaNum(String num){
        preLatex+=num;
    }

    public void dibujaFinDeOperacion(){
        preLatex += "}";
    }

    public void dibujaRaiz(){
        preLatex += "\\sqrt{";
    }

    public void dibujaPotencia(){
        preLatex += "^{";
    }

}
