public class TablaEscalaDeSueldos {
  private double[][] tabla;

  public double[][] getTabla() {
    return this.tabla;
  }

  public void setTabla(double[][] tabla) {
    this.tabla = tabla;
  }

  public TablaEscalaDeSueldos() {
    this.tabla = new double[4][5];
    this.tabla[0][0] = 28.16;
    this.tabla[0][1] = 32.18;
    this.tabla[0][2] = 38.89;
    this.tabla[0][3] = 44.92;
    this.tabla[0][4] = 48.27;
    this.tabla[1][0] = 54.98;
    this.tabla[1][1] = 59.67;
    this.tabla[1][2] = 64.37;
    this.tabla[1][3] = 70.40;
    this.tabla[1][4] = 75.09;
    this.tabla[2][0] = 91.18;
    this.tabla[2][1] = 97.89;
    this.tabla[2][2] = 101.91;
    this.tabla[2][3] = 108.21;
    this.tabla[2][4] = 115.32;
    this.tabla[3][0] = 134.10;
    this.tabla[3][1] = 160.91;
    this.tabla[3][2] = 187.73;
    this.tabla[3][3] = 214.55;
    this.tabla[3][4] = 268.16;
  }

  public double promedioSegunGradoHabilidad(int grado) {
    double promedio = 0;
    if (grado >= 0 && grado < 4) {
      double suma = 0;
      for (int i = 0; i < this.tabla[0].length; i++) {
        suma += this.tabla[grado][i];
      }
      promedio = suma / this.tabla[0].length;
    }
    return promedio;
  }

  public double diferenciaEntreMenorMayorPaga(int grado) {
    double diferencia = 0;
    if (grado >= 0 && grado < this.tabla[0].length) {
      diferencia = this.tabla[grado][4] - this.tabla[grado][0];
    }
    return diferencia;
  }

  public void aumentarMontoGrado(int grado, double monto) {
    if (grado >= 0 && grado < this.tabla[0].length && monto > 0) {
      for (int i = 0; i < this.tabla[0].length; i++) {
        this.tabla[grado][i] += monto;
      }
    }
  }

  @Override
  public String toString() {
    String cadena = "";
    for (int i = 0; i < this.tabla.length; i++) {
      for (int j = 0; j < this.tabla[0].length; j++) {
        cadena += "Grado " + i + ", Habilidad " + j + ": " + this.tabla[i][j] + "\n";
      }
    }
    return cadena;
  }

}
