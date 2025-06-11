import java.util.Calendar;

public class TestListaJugadores {
  public static void main(String[] args) {
    Calendar fecha1 = Calendar.getInstance();
    Calendar fecha2 = Calendar.getInstance();
    Calendar fecha3 = Calendar.getInstance();
    Calendar fecha4 = Calendar.getInstance();
    Calendar fecha5 = Calendar.getInstance();
    fecha1.set(2024, Calendar.JUNE, 11);
    fecha2.set(2024, Calendar.MARCH, 20);
    fecha3.set(2028, Calendar.NOVEMBER, 28);
    fecha4.set(2027, Calendar.APRIL, 17);
    fecha5.set(2025, Calendar.DECEMBER, 25);
    JugadorPrimera jp1 = new JugadorPrimera("Juan", "Romero", 22, "34", fecha1, fecha3);
    JugadorPrimera jp2 = new JugadorPrimera("Esteban", "Valdiviezo", 23, "842", fecha2, fecha4);
    JugadorPrimera jp3 = new JugadorPrimera("Carlos", "Tevez", 21, "39", fecha2, fecha3);
    JugadorPrimera jp4 = new JugadorPrimera("Miguel", "Crespo", 24, "892", fecha1, fecha4);
    JugadorReserva jr1 = new JugadorReserva("Martin", 19, "Cruz", "93", fecha1);
    JugadorReserva jr2 = new JugadorReserva("Sebastian", 18, "Serrano", "362", fecha2);
    ListaJugadores lista = new ListaJugadores();
    lista.agregarJugador(jp1);
    lista.agregarJugador(jp2);
    lista.agregarJugador(jp3);
    lista.agregarJugador(jp4);
    lista.agregarJugador(jr1);
    lista.agregarJugador(jr2);
    lista.imprimirListado();
    System.out.println("En navidad de 2025 habria que pagar en total: $" + lista.importeTotalNominaJugadores(fecha5));
  }
}
