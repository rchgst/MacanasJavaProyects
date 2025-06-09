public class Main {
    public static void main(String[] args) {
        // Crear instancia del listado
        ListadoJugadores listado = new ListadoJugadores();

        // Crear fechas
        Fecha inicio1 = new Fecha(2023, 1, 10);
        Fecha fin1 = new Fecha(2024, 12, 15);
        Fecha inicio2 = new Fecha(2023, 5, 1);
        Fecha inicio3 = new Fecha(2024, 2, 20);

        // Crear jugadores
        JugadorPrimera jugador1 = new JugadorPrimera("Juan", "Pérez", 28, "J001", inicio1, fin1);
        JugadorReserva jugador2 = new JugadorReserva("Carlos", "López", 22, "J002", inicio2);
        JugadorReserva jugador3 = new JugadorReserva("Luis", "Gómez", 19, "J003", inicio3);

        // Agregar al listado
        listado.agregarJugador(jugador1);
        listado.agregarJugador(jugador2);
        listado.agregarJugador(jugador3);

        // Imprimir lista de jugadores
        System.out.println("=== LISTA DE JUGADORES ===");
        listado.imprimirLista();

        // Calcular e imprimir el importe total hasta una fecha
        Fecha hasta = new Fecha(2025, 6, 1);  // Fecha de corte para calcular la nómina
        double totalNomina = listado.importeTotalNominaJugadores(hasta);
        System.out.println("\nIMPORTE TOTAL DE LA NÓMINA HASTA " + hasta + ": $" + totalNomina);
    }
}
