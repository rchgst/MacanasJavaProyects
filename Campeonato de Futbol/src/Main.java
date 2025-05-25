public class Main {
    public static void main(String[] args) {
        //Arquero//
        Jugador Armani = new Jugador(9386483,"Franco Armani",new Fecha(1986,10,16));
        //Defensores//
        Jugador Gonzalo = new Jugador(3836475,"Gonzalo Montiel",new Fecha(1997,1,1));
        Jugador Maindana = new Jugador(83736823,"Jonatan Maidana",new Fecha(1985,7,29));
        Jugador Pinola = new Jugador(89361868,"Javier Pinola",new Fecha(1983,2,24));
        Jugador Casco = new Jugador(83652836,"Milton Casco",new Fecha(1988,4,11));
       //Mediocampistas//
        Jugador Enzo = new Jugador(9374627,"Enzo Perez",new Fecha(1986,2,22));
        Jugador Ponzio = new Jugador(83761231,"Leandro Ponzio",new Fecha(1982,1,29));
        Jugador Nacho = new Jugador(927510283,"Ignacion Fernandez",new Fecha(1990,1,12));
        Jugador Pity = new Jugador(2342342,"Gonzalo Martinez",new Fecha(2018,12,9));
        Jugador Juanfer = new Jugador(73656361,"Juan Fernando Quinteros,",new Fecha(1993,1,18));
        //Delanteros//
        Jugador Pratto = new Jugador(1234122,"Lucas Pratto", new Fecha(1988,6,4));
        Jugador Arania = new Jugador(83766172,"Julian Alvarez",new Fecha(2000,1,31));
        Tecnico Gallardo = new Tecnico("Gallardo");
        Equipo River = new Equipo(Gallardo,"River Plate");
        River.agregarJugador(Arania);
        River.agregarJugador(Armani);
        River.agregarJugador(Gonzalo);
        River.agregarJugador(Maindana);
        River.agregarJugador(Pity);
        River.agregarJugador(Pinola);
        River.agregarJugador(Casco);
        River.agregarJugador(Enzo);
        River.agregarJugador(Ponzio);
        River.agregarJugador(Nacho);
        River.agregarJugador(Juanfer);
        River.agregarJugador(Pratto);
        Gallardo.cargarCompetencia("Libertadores");
        Partido finalLibertadores = new Partido("Boca Juniors",3,1,"Libertadores",new TiempoPartido(2,3),new Fecha(2018,12,9));
        finalLibertadores.setJugadorConAmarilla(Ponzio);
        finalLibertadores.setJugadorConAmarilla(Nacho);
        finalLibertadores.setJugadorConAmarilla(Casco);
        finalLibertadores.setJugadorConAmarilla(Maindana);
        River.agregarPartido(finalLibertadores);
        System.out.println(River.toString()+"\n"+ "Murio boquita :(");
    }
}