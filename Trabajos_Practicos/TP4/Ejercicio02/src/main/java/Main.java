import java.util.ArrayList;

public class Main {
  public static void main(final String[] args) {
    TablaProduccionAnualCereales tabla = new TablaProduccionAnualCereales();
    int[][] produccion = new int[3][12];
    int p = 0;
    for (int i = 0; i < produccion.length; i++) {
      for (int j = 0; j < produccion[0].length; j++) {
        produccion[i][j] = ++p;
      }
    }
    tabla.setTablaProduccion(produccion);
    System.out.println(tabla);
    ArrayList<Double> promedios = tabla.promedioAnualPorCereal();
    int contador = 0;
    for (Double double1 : promedios) {
      System.out.println("Promedio anual del cereal " + contador + ": " + double1);
      ++contador;
    }
    ArrayList<Integer> cosechaSuperior = tabla.cantidadMesesConMayorProduccionAlPromedio();
    contador = 0;
    for (Integer integer : cosechaSuperior) {
      System.out.println("Meses que hubo cosecha superior al promedio del cereal " + contador + ": " + integer);
      ++contador;
    }
    ArrayList<Integer> cosechaInferior = tabla.cantidadMesesConMenorProduccionAlPromedio();
    contador = 0;
    for (Integer integer : cosechaSuperior) {
      System.out.println("Meses que hubo cosecha inferior al promedio del cereal " + contador + ": " + integer);
      ++contador;
    }
    ArrayList<String> mesesMayorProduccion = tabla.mesesDeMayorProduccion();
    contador = 0;
    for (String string : mesesMayorProduccion) {
      System.out.println("El mes que mas cereal " + contador + " se produjo: " + string);
      ++contador;
    }
  }
}
