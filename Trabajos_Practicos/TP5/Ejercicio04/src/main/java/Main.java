public class Main {
  public static void main(String[] args) {
    Alumno a1 = new Alumno("Juan Cierra", 'M', 42834333, 428343, "Exactas", "Lic. en Analisis de Sistemas", 2022, 50,
        60, 0, 65, 70);
    Alumno a2 = new Alumno("Marcela Vargas", 'F', 42478299, 424782, "Humanidades", "Profesorado de Historia", 2023, 70,
        0, 80, 0, 85);
    Alumno a3 = new Alumno("Mario Avellaneda", 'M', 43873949, 438739, "Ingenieria", "Ingenieria Quimica", 2024, 30, 40,
        0, 0, 0);
    Alumno a4 = new Alumno("Gerardo Gutierrez", 'M', 41750184, 417501, "Economicas",
        "Lic. en Administracion de Empresas", 2022, 60, 0, 40, 55, 0);
    Alumno a5 = new Alumno("Fernanda Flores", 'F', 41892347, 418923, "Exactas",
        "Tecnicatura Universitaria en Programacion", 2023, 0, 0, 0, 0, 0);
    ListaAlumnos lista = new ListaAlumnos();
    lista.agregarAlumno(a1);
    lista.agregarAlumno(a2);
    lista.agregarAlumno(a3);
    lista.agregarAlumno(a4);
    lista.agregarAlumno(a5);
    lista.mostrarAlumnos();
    System.out.println("Cantidad de Libres: " + lista.cantLibres());
    System.out.println("Cantidad de Regulares: " + lista.cantRegulares());
    System.out.println("Cantidad de Abandonos: " + lista.cantAbandonos());
  }
}
