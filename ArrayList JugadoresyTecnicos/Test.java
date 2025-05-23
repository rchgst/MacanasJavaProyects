public class Test {
    public static void main (String [] args){
        EquipoF5 equipo= new EquipoF5();
        Jugadores Jugador1= new Jugadores("JP",123,"04/06/2008");
        Jugadores Jugador2= new Jugadores("JH",456,"04/06/2008");
        Jugadores Jugador3= new Jugadores("JH",789,"04/06/2008");
        Jugadores Jugador4= new Jugadores("JH",101,"04/06/2008");
        equipo.AgregaJugador(Jugador1);
        equipo.AgregaJugador(Jugador2);
        equipo.AgregaJugador(Jugador3);
        equipo.AgregaJugador(Jugador4);
        System.out.println(equipo.toString());
        System.out.println("---------------------------------------");;
        equipo.EliminaJugador(Jugador1);
        System.out.println(equipo.toString());
    }
}
