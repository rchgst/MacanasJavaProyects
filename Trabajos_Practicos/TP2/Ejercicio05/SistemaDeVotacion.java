import java.util.ArrayList;

public class SistemaDeVotacion {
  private ArrayList<Votante> votantes = new ArrayList<>();

  public static void main(String[] args) {
    SistemaDeVotacion sis = new SistemaDeVotacion();
    sis.cargaListaVotantes();
    ArrayList<Alumno> alumnosVotantes = new ArrayList<>();
    alumnosVotantes = sis.alumnosAutorizadosAVotar();
    for (Alumno alumno : alumnosVotantes) {
      System.out.println(alumno);
    }
    int dniBuscar = 31889604;
    String nombreBuscar = "Esteban Henriquez";
    if (sis.estaAutorizadoAVotar(nombreBuscar, dniBuscar)) {
      System.out.println("Esta autorizado a votar");
    } else {
      System.out.println("No esta autorizado a votar");
    }
    System.out.println(
        "Porcentaje de Alumnos que pueden votar (respecto al total de alumnos): " + sis.porcentajeDeAlumnosVotantes());
    System.out.println(
        "Porcentaje de Docentes que pueden votar (respecto al total de docentes): "
            + sis.porcentajeDeDocentesVotantes());
  }

  public void cargaListaVotantes() {
    Alumno a1 = new Alumno(3, "Maira Rodriguez", 44134044);
    Alumno a2 = new Alumno(1, "Martin Guzman", 45338001);
    Alumno a3 = new Alumno(2, "Anahi Ceballos", 41088121);
    Docente d1 = new Docente(true, "Sergio Cabero", 32058733);
    Docente d2 = new Docente(false, "Esteban Henriquez", 31889604);
    Docente d3 = new Docente(true, "Marcela Lopez", 33771143);
    Personal p1 = new Personal("Ricardo Bolañez", 38702194);
    Personal p2 = new Personal("Guillermo Romero", 35890022);
    this.votantes.add(a1);
    this.votantes.add(a2);
    this.votantes.add(a3);
    this.votantes.add(d1);
    this.votantes.add(d2);
    this.votantes.add(d3);
    this.votantes.add(p1);
    this.votantes.add(p2);
  }

  public ArrayList<Alumno> alumnosAutorizadosAVotar() {
    ArrayList<Alumno> alumnos = new ArrayList<>();
    for (Votante votante : this.votantes) {
      if (votante instanceof Alumno && votante.puedeVotar()) {
        System.out.println("Se agrego un alumno");
        alumnos.add((Alumno) votante);
      }
    }
    return alumnos;
  }

  public boolean estaAutorizadoAVotar(String nombre, int dni) {
    for (Votante votante : this.votantes) {
      if (votante.getNombre().equals(nombre) && votante.getDni() == dni) {
        if (votante.puedeVotar()) {
          return true;
        } else {
          if (votante instanceof Alumno) {
            System.out.println("No tiene las materias finalizadas requeridas");
          } else {
            System.out.println("No tiene un cargo regular en alguna materia");
          }
          return false;
        }
      }
    }
    System.out.println("No hay un votante con esos datos");
    return false;
  }

  public double porcentajeDeAlumnosVotantes() {
    double contAlumnosTotal = 0, contAlumnosVotantes = 0;
    for (Votante votante : this.votantes) {
      if (votante instanceof Alumno) {
        ++contAlumnosTotal;
        if (votante.puedeVotar()) {
          ++contAlumnosVotantes;
        }
      }
    }
    if (contAlumnosTotal == 0) {
      return 0;
    } else {
      return 100 * contAlumnosVotantes / contAlumnosTotal;
    }
  }

  public double porcentajeDeDocentesVotantes() {
    double contDocentesTotal = 0, contDocentesVotantes = 0;
    for (Votante votante : this.votantes) {
      if (votante instanceof Docente) {
        ++contDocentesTotal;
        if (votante.puedeVotar()) {
          ++contDocentesVotantes;
        }
      }
    }
    if (contDocentesTotal == 0) {
      return 0;
    } else {
      return 100 * contDocentesVotantes / contDocentesTotal;
    }
  }
}
