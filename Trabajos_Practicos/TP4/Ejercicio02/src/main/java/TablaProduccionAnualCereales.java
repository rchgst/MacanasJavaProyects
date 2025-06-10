import java.util.ArrayList;

public class TablaProduccionAnualCereales {
  private int[][] tablaProduccion;

  public TablaProduccionAnualCereales(int[][] tablaProduccion) {
    if (tablaProduccion[0].length == 12) {
      this.tablaProduccion = tablaProduccion;
    }
  }

  public TablaProduccionAnualCereales(int cantidadCereales) {
    this.tablaProduccion = new int[cantidadCereales][12];
  }

  public TablaProduccionAnualCereales() {
  }

  public int[][] getTablaProduccion() {
    return this.tablaProduccion;
  }

  public void setTablaProduccion(int[][] tablaProduccion) {
    if (tablaProduccion[0].length == 12) {
      this.tablaProduccion = tablaProduccion;
    }
  }

  public ArrayList<Double> promedioAnualPorCereal() {
    ArrayList<Double> promedios = null;
    if (this.tablaProduccion != null) {
      promedios = new ArrayList<>();
      double suma = 0;
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          suma += this.tablaProduccion[i][j];
        }
        promedios.add(suma / this.tablaProduccion[0].length);
      }
    }
    return promedios;
  }

  public ArrayList<Integer> cantidadMesesConMayorProduccionAlPromedio() {
    ArrayList<Integer> cantidad = null;
    if (this.tablaProduccion != null) {
      int contador = 0;
      cantidad = new ArrayList<>();
      ArrayList<Double> promedios = promedioAnualPorCereal();
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          if (promedios.get(i) < this.tablaProduccion[i][j]) {
            ++contador;
          }
        }
        cantidad.add(contador);
      }
    }
    return cantidad;
  }

  public ArrayList<Integer> cantidadMesesConMenorProduccionAlPromedio() {
    ArrayList<Integer> cantidad = null;
    if (this.tablaProduccion != null) {
      int contador = 0;
      cantidad = new ArrayList<>();
      ArrayList<Double> promedios = promedioAnualPorCereal();
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          if (promedios.get(i) > this.tablaProduccion[i][j]) {
            ++contador;
          }
        }
        cantidad.add(contador);
      }
    }
    return cantidad;
  }

  public ArrayList<String> mesesDeMayorProduccion() {
    ArrayList<String> meses = null;
    if (this.tablaProduccion != null) {
      meses = new ArrayList<>();
      int mes = 0;
      int mayor = 0;
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          if (this.tablaProduccion[i][j] > mayor) {
            mayor = this.tablaProduccion[i][j];
            mes = j;
          }
        }
        mayor = 0;
        meses.add(mes(mes));
      }
    }
    return meses;
  }

  private String mes(int mes) {
    String mesCadena = null;
    switch (mes) {
      case 0:
        mesCadena = "Enero";
        break;
      case 1:
        mesCadena = "Febrero";
        break;
      case 2:
        mesCadena = "Marzo";
        break;
      case 3:
        mesCadena = "Abril";
        break;
      case 4:
        mesCadena = "Mayo";
        break;
      case 5:
        mesCadena = "Junio";
        break;
      case 6:
        mesCadena = "Julio";
        break;
      case 7:
        mesCadena = "Agosto";
        break;
      case 8:
        mesCadena = "Septiembre";
        break;
      case 9:
        mesCadena = "Octubre";
        break;
      case 10:
        mesCadena = "Noviembre";
        break;
      case 11:
        mesCadena = "Diciembre";
        break;
      default:
        System.out.println("Mes no reconocido");
        break;
    }
    return mesCadena;
  }

  @Override
  public String toString() {
    String cadena = "";
    if (this.tablaProduccion != null) {
      for (int i = 0; i < this.tablaProduccion.length; i++) {
        for (int j = 0; j < this.tablaProduccion[0].length; j++) {
          cadena += "Cereal " + i + ", Mes: " + mes(j) + ", Toneladas cosechadas: " + this.tablaProduccion[i][j] + "\n";
        }
      }
    }
    return cadena;
  }

}
