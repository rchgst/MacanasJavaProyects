public class Main {
  public static void main(String[] args) {
    Jugador jug1 = new Jugador(1, "Damian Perez", new Fecha(20, 8, 1978));
    Jugador jug2 = new Jugador(2, "Esteban Gonzales", new Fecha(22, 2, 1980));
    Jugador jug3 = new Jugador(3, "Ariel Carabajal", new Fecha(25, 1, 1984));
    Jugador jug4 = new Jugador(4, "Roman Riquelme", new Fecha(8, 6, 1985));
    Jugador jug5 = new Jugador(5, "Diego Armani", new Fecha(20, 3, 1983));
    Jugador jug6 = new Jugador(6, "Fabian Crespo", new Fecha(23, 3, 1979));
    Jugador jug7 = new Jugador(7, "Juan Cabani", new Fecha(13, 12, 1984));
    Jugador jug8 = new Jugador(8, "Miguel Martinez", new Fecha(10, 5, 1988));
    Equipo equipo = new Equipo();
    equipo.agregarJugador(jug1);
    equipo.agregarJugador(jug2);
    equipo.agregarJugador(jug3);
    equipo.agregarJugador(jug4);
    equipo.agregarJugador(jug5);
    equipo.agregarJugador(jug6);
    equipo.agregarJugador(jug7);
    equipo.agregarJugador(jug8);
    System.out.println(equipo);
    equipo.eliminarJugador(jug6);
    equipo.eliminarJugador(jug2);
    System.out.println(equipo);
  }
}
