public class PrecipitacionAnual {

  private double[] listaPrecipitaciones;
  private int indiceACargar;

  public PrecipitacionAnual() {
    this.listaPrecipitaciones = new double[12];
  }

  public void cargarPrecipActual(double valor) {
    if (this.indiceACargar < 12) {
      this.listaPrecipitaciones[this.indiceACargar] = valor;
      ++this.indiceACargar;
    } else {
      this.indiceACargar = 0;
      this.listaPrecipitaciones[this.indiceACargar] = valor;
    }
  }

  public void cargarPrecipMes(int indice, double valor) {
    if (indice > this.indiceACargar) {
      this.listaPrecipitaciones[this.indiceACargar] = valor;
    } else {
      this.listaPrecipitaciones[indice] = valor;
    }
  }

  public double calcularPromedioActual() {
    double suma = 0;
    for (int i = 0; i < this.indiceACargar; i++) {
      suma += this.listaPrecipitaciones[i];
    }
    return suma / this.indiceACargar;
  }

  public double promedioAnual() {
    if (this.indiceACargar == 12) {
      return calcularPromedioActual();
    } else {
      System.out.println("No se puede sacar el promedio anual porque no se cargaron todos los datos");
      return 0;
    }
  }

  public double[] calcularListaDesvios() {
    double promedio = calcularPromedioActual();
    double[] listaDesvios = this.listaPrecipitaciones;
    for (int i = 0; i < listaDesvios.length; i++) {
      listaDesvios[i] -= promedio;
    }
    return listaDesvios;
  }
}
