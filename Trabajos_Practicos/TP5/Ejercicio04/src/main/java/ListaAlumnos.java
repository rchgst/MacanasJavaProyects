import java.util.ArrayList;

public class ListaAlumnos {
  private ArrayList<Alumno> alumnos;

  public ListaAlumnos() {
    this.alumnos = new ArrayList<>();
  }

  public ListaAlumnos(ArrayList<Alumno> alumnos) {
    this.alumnos = alumnos;
  }

  public void agregarAlumno(Alumno alumno) {
    this.alumnos.add(alumno);
  }

  public void mostrarAlumnos() {
    if (!(this.alumnos.isEmpty())) {
      for (Alumno alumno : this.alumnos) {
        alumno.showStudent();
      }
    }
  }

  public int cantRegulares() {
    int cantidad = 0;
    if (!(this.alumnos.isEmpty())) {
      for (Alumno alumno : this.alumnos) {
        if (alumno.estaRegular()) {
          ++cantidad;
        }
      }
    }
    return cantidad;
  }

  public int cantLibres() {
    int cantidad = 0;
    if (!(this.alumnos.isEmpty())) {
      for (Alumno alumno : this.alumnos) {
        if (alumno.estaLibre()) {
          ++cantidad;
        }
      }
    }
    return cantidad;
  }

  public int cantAbandonos() {
    int cantidad = 0;
    if (!(this.alumnos.isEmpty())) {
      for (Alumno alumno : this.alumnos) {
        if (alumno.estaAusente()) {
          ++cantidad;
        }
      }
    }
    return cantidad;
  }
}
