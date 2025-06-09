public class TestCirugias {
  public static void main(String[] args) {
    Fecha fecha1 = new Fecha(2024, 5, 15);
    Fecha fecha2 = new Fecha(2024, 6, 27);
    Fecha fecha3 = new Fecha(2024, 10, 20);
    Fecha fecha4 = new Fecha(2024, 7, 1);
    Fecha fecha5 = new Fecha(2024, 11, 7);
    ObraSocial obraSocial1 = new ObraSocial(847277384, "OSDE", "Buenos Aires, Capital");
    ObraSocial obraSocial2 = new ObraSocial(848704832, "PIEVE", "Salta, Salta Capital");
    Paciente paciente1 = new Paciente(31488934, "Juana Martinez", 'F', new Fecha(1974, 4, 22), obraSocial1);
    Paciente paciente2 = new Paciente(37483983, "Esteban Pacheco", 'M', new Fecha(1977, 1, 30), obraSocial1);
    Paciente paciente3 = new Paciente(41483745, "Marian Costanera", 'F', new Fecha(1999, 7, 22), obraSocial2);
    Paciente paciente4 = new Paciente(39574833, "Fabio Renato", 'M', new Fecha(1991, 8, 13), obraSocial2);
    Profesional profesional1 = new Profesional(32485399, "Maria de los Angeles Fernandez", 'F', new Fecha(1975, 11, 7),
        3828);
    Profesional profesional2 = new Profesional(38733817, "Juan Pablo Estebanez", 'M', new Fecha(1989, 3, 25), 883293);
    Cirugia cirugia1 = new Cirugia(1, "Cambio de Bypass", paciente1, profesional1, fecha1, 180);
    Cirugia cirugia2 = new Cirugia(20, "Extraccion de Apendice", paciente2, profesional2, fecha3, 200);
    Cirugia cirugia3 = new Cirugia(15, "Trasplante de riñon", paciente4, profesional2, fecha2, 300);
    Cirugia cirugia4 = new Cirugia(23, "Amputacion de piernas", paciente3, profesional1, fecha4, 500);
    Cirugia cirugia5 = new Cirugia(84, "Trasplante de piel", paciente3, profesional2, fecha5, 390);
    Cirugia cirugia6 = new Cirugia(88, "Implante de cadera", paciente1, profesional1, fecha3, 700);
    Cirugias cirugias = new Cirugias();
    cirugias.insertarCirugia(cirugia1);
    cirugias.insertarCirugia(cirugia2);
    cirugias.insertarCirugia(cirugia3);
    cirugias.insertarCirugia(cirugia4);
    cirugias.insertarCirugia(cirugia5);
    cirugias.insertarCirugia(cirugia6);
    System.out.println(cirugias);
    System.out.println("Promedio duracion de todas las cirugias en la lista: " +
        cirugias.promedioDuracion());
    System.out.println("Se mostraran las cirugias del paciente: " +
        paciente3.getNombre());
    System.out.println(cirugias.cirugiasPcte(paciente3));
    System.out.println("Cirugias de la obra social: " +
        obraSocial2.getDenominacion());
    System.out.println(cirugias.cirugiasOS(obraSocial2.getDenominacion()));
    System.out.println("Cirugias que realiza el/la prestador: " +
        profesional1.getNombre());
    System.out.println(cirugias.cirugiasPrestador(profesional1.getNombre()));
    System.out.println("Promedio de la duracion de cirugias de entre " +
        fecha1.toString() + " hasta "
        + fecha3.toString() + ": " + cirugias.promedioDuracion(fecha1, fecha3));
    System.out.println("Promedio de duracion de operaciones de personas de 26 años: " + cirugias.promedioDuracion(26));
  }
}
