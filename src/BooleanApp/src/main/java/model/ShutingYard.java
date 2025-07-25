
package model;

import java.util.*;

public class ShutingYard {
    private String expresion;
    private Map<String, Integer>precedencia;
    private Map<String,String>asociatividad;

    public ShutingYard(String expresion){
        this.expresion = expresion;
        precedencia = new HashMap<>();
        asociatividad = new HashMap<>();

        precedencia.put("!",3);
        precedencia.put("&",2);
        precedencia.put("^",1);
        precedencia.put("|",1);

        asociatividad.put("!","right");
        asociatividad.put("&","left");
        asociatividad.put("^","left");
        asociatividad.put("|","left");

    }

    // Verifica si el token es un operador lógico
    private boolean esOperador(String token) {
        return precedencia.containsKey(token);
    }

    // Verifica si es una variable (a, b, c...)
    private boolean esVariable(String token) {
        return token.matches("[a-f]");
    }

    public boolean esParentesisIzquierdo(String token){
        return token.equals("(");
    }

    public boolean esParentesisDerecho(String token){
        return token.equals(")");
    }

    public int obtenerPrecedencia(String operador){
        return precedencia.get(operador);
    }

    public boolean esAsociativoADerecha(String operador){
        return asociatividad.get(operador).equals("right");
    }

    public void acomodaPilaYSalida(StringTokenizer tokens,List<String>salida,Stack<String>pila){
        while (tokens.hasMoreElements()){
            String token = tokens.nextToken().trim();
            if(token.isEmpty()){continue;}

            if(this.esVariable(token)){salida.add(token);}

            if(this.esParentesisIzquierdo(token)){pila.push(token);}

            if (this.esParentesisDerecho(token)){
                while (!pila.isEmpty() && !pila.peek().equals("(")){
                    salida.add(pila.pop());
                }
                pila.pop();
            }
            if(this.esOperador(token)){
                while (!pila.isEmpty() && esOperador(pila.peek()) && (precedencia.get(token) < precedencia.get(pila.peek()) ||
                        (precedencia.get(token).equals(precedencia.get(pila.peek())) &&
                        !esAsociativoADerecha(token)))) {
                    salida.add(pila.pop());
                }
                pila.push(token);
            }
        }
    }

    private void vaciaPilaASalida(List<String>salida,Stack<String>pila){
        while (!pila.isEmpty()){
            salida.add(pila.pop());
        }
    }

    public List<String> infijoToPostfijo(){
        List<String> salida = new ArrayList<>();
        Stack<String> pila = new Stack<>();
        StringTokenizer tokens = new StringTokenizer(expresion," ()&|^!",true);
        this.acomodaPilaYSalida(tokens,salida,pila);
        this.vaciaPilaASalida(salida,pila);
        return salida;
    }

    public boolean evaluarPostfija(List<String> postfijo, Map<Character, Boolean> valores) {
        Stack<Boolean> pila = new Stack<>();

        for (String token : postfijo) {
            if (esVariable(token)) {
                pila.push(valores.get(token.charAt(0))); // obtenemos el valor de esa variable
            } else if (token.equals("!")) {
                boolean a = pila.pop();
                pila.push(!a);
            } else if (token.equals("&")) {
                boolean b = pila.pop();
                boolean a = pila.pop();
                pila.push(a && b);
            } else if (token.equals("|")) {
                boolean b = pila.pop();
                boolean a = pila.pop();
                pila.push(a || b);
            } else if (token.equals("^")) {
                boolean b = pila.pop();
                boolean a = pila.pop();
                pila.push(a ^ b);
            }
        }
        return pila.pop(); // resultado final
    }
}
