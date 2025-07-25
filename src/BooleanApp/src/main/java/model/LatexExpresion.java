
package model;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.scilab.forge.jlatexmath.TeXFormula;

import java.awt.image.BufferedImage;

public class LatexExpresion {
    private String expresion;

    public LatexExpresion(){
        expresion = "";
    }

    public void addString(String expresionLatex){
        expresion += expresionLatex;
    }

    public void notInExpresion(){
        addString("\\overline{");
    }

    public void closeExpresion(){
        addString("}");
    }

    public void andInExpresion(){
        addString(" \\cdot ");
    }

    public void orInExpresion(){
        addString(" + ");
    }

    public void xorInExpresion(){
        addString(" \\oplus ");
    }

    public void variableInExpresion(String variable){
        addString(variable);
    }

    public void parentesisIzqInExpresion(){
        addString("(");
    }

    public void parentesisDerInExpresion(){
        addString(")");
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public void mostrarLatexExpresion(){
        System.out.println(expresion);
    }

    @Override
    public String toString() {
        return "LatexExpresion{" +
                "expresion='" + expresion + '\'' +
                '}';
    }

    public static Image renderToImage(String latexExpresion,int fontSize){
        TeXFormula formula = new TeXFormula(latexExpresion);
        BufferedImage image = (BufferedImage) formula.createBufferedImage(TeXFormula.SERIF, fontSize, java.awt.Color.BLACK, null);
        return SwingFXUtils.toFXImage(image, null);
    }
}
