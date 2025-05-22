public class Main {
  public static void main(String[] args) {
    Fecha date = new Fecha();
    date.fechaActual();
    System.out.println(date);
    date.setFecha(2025, 9, 17);
    System.out.println(date);
    Internado p1 = new Internado("Juan Perez", 12301943, "Barrio Palmeras", "3878499103");
    System.out.println(p1);
    Ambulatorio p2 = new Ambulatorio("Marian Estebanez", 44488812, "Barrio Morosini", "3874042702",
        "Paciente con resfriado comun");
    System.out.println(p2);
  }
}
