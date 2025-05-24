public class Main {
    public static void main(String[] args) {
        // Crear sistema de votación
        SistemaDeVotacion sistema = new SistemaDeVotacion();

        // Crear partidos
        Partido partido1 = new Partido(101);
        Partido partido2 = new Partido(102);
        sistema.agregarPartido(partido1);
        sistema.agregarPartido(partido2);

        // Crear votantes de distintos tipos
        Alumno alumno1 = new Alumno("Lucía", 12345678L, 3);
        Alumno alumno2 = new Alumno("Mateo", 23456789L, 2); // No puede votar
        Docente docente1 = new Docente(34567890L, "Prof. Ana", true);
        Docente docente2 = new Docente(45678901L, "Prof. Luis", false); // No puede votar
        Personal personal1 = new Personal("Carlos", 56789012L); // Siempre puede votar

        // Agregar votantes al sistema
        sistema.agregarVotante(alumno1);
        sistema.agregarVotante(alumno2);
        sistema.agregarVotante(docente1);
        sistema.agregarVotante(docente2);
        sistema.agregarVotante(personal1);

        // Mostrar alumnos habilitados
        sistema.muestraAlumnos();

        // Mostrar porcentajes de habilitados
        sistema.muestraPorc();

        // Realizar votación (solo si puede votar)
        if (alumno1.puedeVotar()) alumno1.votar(partido1); // +1
        if (docente1.puedeVotar()) docente1.votar(partido2); // +3 (por herencia)
        if (personal1.puedeVotar()) personal1.votar(partido1); // +3

        // Mostrar resultados
        System.out.println("\nRESULTADOS:");
        System.out.println("Partido " + partido1.getNumId() + ": " + partido1.getCantVotos() + " votos");
        System.out.println("Partido " + partido2.getNumId() + ": " + partido2.getCantVotos() + " votos");

        // Consultar estado de votantes
        alumno2.consultarVotante(alumno2);
        docente2.consultarVotante(docente2);
    }
}
