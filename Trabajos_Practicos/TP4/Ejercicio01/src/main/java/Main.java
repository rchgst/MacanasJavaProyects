public class Main {
  public static void main(String[] args) {
    TablaEscalaDeSueldos tabla = new TablaEscalaDeSueldos();
    System.out.println("Promedio de paga del grado 0: " + tabla.promedioSegunGradoHabilidad(0));
    System.out.println("Diferencia entre la menor y mayor paga del grado 3: " + tabla.diferenciaEntreMenorMayorPaga(3));
    tabla.aumentarMontoGrado(2, 10);
    System.out.println(tabla);
  }
}
