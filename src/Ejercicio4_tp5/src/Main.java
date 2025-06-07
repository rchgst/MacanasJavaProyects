import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumno> lista = new ArrayList<>();

        // Agregar alumnos de ejemplo
        lista.add(new Alumno("Ana", 'F', 12345678, 1001, "FCE", "Tecnicatura", 2023, 70, 0, 75, 0, 6));   // regular
        lista.add(new Alumno("Luis", 'M', 23456789, 1002, "FCE", "Tecnicatura", 2023, 50, 40, 30, 50, 4)); // libre
        lista.add(new Alumno("Clara", 'F', 34567890, 1003, "FCE", "Tecnicatura", 2023, 0, 0, 0, 0, 0));    // ausente
        lista.add(new Alumno("Pedro", 'M', 45678901, 1004, "FCE", "Tecnicatura", 2023, 60, 0, 0, 70, 6));  // regular (segundo parcial aprobado)
        lista.add(new Alumno("Julia", 'F', 56789012, 1005, "FCE", "Tecnicatura", 2023, 0, 0, 55, 50, 4));  // libre

        // Crear instancia de ListaAlumnos
        ListaAlumnos listaAlumnos = new ListaAlumnos(lista);

        // Mostrar resultados
        System.out.println("Cantidad de alumnos REGULARES: " + listaAlumnos.cantRegulares());
        System.out.println("Cantidad de alumnos LIBRES: " + listaAlumnos.cantLibres());
        System.out.println("Cantidad de alumnos AUSENTES: " + listaAlumnos.cantAusentes());

        // Mostrar todos los alumnos
        System.out.println("\n--- Detalle de alumnos ---");
        for (Alumno a : lista) {
            a.showStudent();
        }
    }
}
