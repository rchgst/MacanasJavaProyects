
package model;

public class ExpresionParser {
    private String expresion;

    public ExpresionParser(String expresion) {
        this.expresion = expresion;
    }

    public ExpresionParser(){
        expresion = "";
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public void notInExpresion(){
        expresion+="!";
    }

    public void andInExpresion(){
        expresion+="&";
    }

    public void orInExpresion(){
        expresion+="|";
    }

    public void xorInExpresion(){
        expresion += "^";
    }

    public void parentesisIzqInExpresion(){
        expresion+="(";
    }

    public void parentesisDerInExpresion(){
        expresion+=")";
    }

    public void variableInExpresion(char variable) {
        expresion += variable;
    }


    public void mostrarExpresion(){
        System.out.println(expresion);
    }

    public int countChars(char c){
        int count=0;

        for(char letra : expresion.toCharArray())
            if(letra == c)
                count++;

        return count;
    }

    public boolean validarParentesis(){
        int cantParentesisIzq = countChars('(');
        int cantParentesisDer = countChars(')');

        return cantParentesisIzq == cantParentesisDer;
    }

    public boolean variableValidate(char variable, int cantVariable) {
        return variable >= 'a' && variable < ('a' + cantVariable);
    }

    public boolean esOperador(char c){
        return c=='&' || c=='|' || c=='!' || c=='^';
    }

    public boolean esParentesis(char c){
        return c=='(' || c==')';
    }

    public boolean variablesValidas(int cantVariable){
        for(char letra : expresion.toCharArray())
            if(!esOperador(letra) && !esParentesis(letra))
                if(!variableValidate(letra,cantVariable))
                    return false;
        return true;
    }

    public boolean coherenciaDeOperadores(){
        String expresionAux = expresion.replace("&","<>");
        String ors = expresionAux.replace("|","<>");
        String value = ors.replace("!","}");

        if(value.contains("><") || value.contains("}<"))
            return false;
        return true;
    }

    public boolean expresionValida(int cantVariable){
        return validarParentesis() && variablesValidas(cantVariable) && coherenciaDeOperadores();
    }

    public void limpiarExpresion() {
        expresion = "";
    }

    public void insertarANDImplicitos() {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < expresion.length(); i++) {
            char actual = expresion.charAt(i);
            char siguienteDos = actual;
            resultado.append(actual);

            if (i < expresion.length() - 1) {
                char siguiente = expresion.charAt(i + 1);
                if(i+2<expresion.length())
                    siguienteDos = expresion.charAt(i+2);

                // Si hay: letra seguida de letra → ej. "ab"
                if (Character.isLetter(actual) && Character.isLetter(siguiente)) {
                    resultado.append('&');
                }

                // Si hay: letra seguida de '(' → ej. "a(b)"
                else if (Character.isLetter(actual) && siguiente == '(') {
                    resultado.append('&');
                }

                // Si hay: ')' seguida de letra → ej. ")a"
                else if (actual == ')' && Character.isLetter(siguiente)) {
                    resultado.append('&');
                }

                // Si hay: ')' seguida de '(' → ej. ")("
                else if (actual == ')' && siguiente == '(') {
                    resultado.append('&');
                }
                else if(Character.isLetter(actual) && siguiente == '!' && Character.isLetter(siguienteDos))
                    resultado.append('&');
            }
        }

        expresion = String.valueOf(resultado);
    }


}
