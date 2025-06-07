import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        // Crear instancia del listado
        ListadoJugadores listado = new ListadoJugadores();

        // Crear fechas
        LocalDate inicio1 = LocalDate.of(2023, 1, 1);
        LocalDate fin1 = LocalDate.of(2025, 12, 31);

        LocalDate inicio2 = LocalDate.of(2022, 6, 15);
        LocalDate inicio3 = LocalDate.of(2024, 3, 10);

        // Crear jugadores
        JugadorPrimera jugador1 = new JugadorPrimera("Juan", "Pérez", 25, "JP001", inicio1, fin1);
        JugadorReserva jugador2 = new JugadorReserva("Luis", "Gómez", 20, "LG002", inicio2);
        JugadorPrimera jugador3 = new JugadorPrimera("Carlos", "Ramírez", 27, "CR003", inicio3, fin1);

        // Agregar jugadores al listado
        listado.agregarJugador(jugador1);
        listado.agregarJugador(jugador2);
        listado.agregarJugador(jugador3);

        // Imprimir listado
        listado.imprimirListado();

        // Calcular e imprimir el total de la nómina
        LocalDate hoy = LocalDate.now();
        double totalNomina = listado.importeTotalNominaJugadores(hoy);
        System.out.println("\nImporte total de la nómina de jugadores hasta hoy: $" + totalNomina);
    }
}
