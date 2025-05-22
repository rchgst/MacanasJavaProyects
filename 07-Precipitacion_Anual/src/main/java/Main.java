public class Main {
  public static void main(String[] args) {
    PrecipitacionAnual p = new PrecipitacionAnual();
    p.cargarPrecipActual(25.8);
    p.cargarPrecipActual(22.4);
    p.cargarPrecipActual(27.7);
    p.cargarPrecipActual(17.3);
    p.cargarPrecipActual(10.1);
    p.cargarPrecipActual(8.2);
    p.cargarPrecipActual(0.4);
    p.cargarPrecipActual(1.2);
    p.cargarPrecipActual(1);
    p.cargarPrecipActual(0.8);
    System.out.println("El promedio actual de precipitaciones es: " + p.calcularPromedioActual());
    p.cargarPrecipMes(7, 0.9);
    double[] listaDesvios = p.calcularListaDesvios();
    System.out.println("Nuevo promedio: " + p.calcularPromedioActual());
    System.out.println("Una lista de desvios del promedio");
    for (int i = 0; i < listaDesvios.length; i++) {
      System.out.println("Mes " + (i + 1) + ": " + listaDesvios[i]);
    }
    p.cargarPrecipActual(1.2);
    p.cargarPrecipActual(1.8);
    System.out.println("Promedio anual de precipitaciones: " + p.promedioAnual());
  }
}
