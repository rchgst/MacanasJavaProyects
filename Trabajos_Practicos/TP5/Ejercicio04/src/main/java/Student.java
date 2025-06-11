public class Student extends Person {
  long LU;
  String facultad;
  String carrera;
  int anioIngreso;

  Student(String nombre, char sexo, long dni, long lu, String facultad, String carrera, int anioIngreso) {
    super(nombre, sexo, dni);
    this.LU = lu;
    this.facultad = facultad;
    this.carrera = carrera;
    this.anioIngreso = anioIngreso;
  }

  long getLu() {
    return this.LU;
  }
}
