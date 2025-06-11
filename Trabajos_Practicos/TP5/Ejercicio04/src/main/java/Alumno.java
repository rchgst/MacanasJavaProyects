public class Alumno extends AbsStudent {

  public Alumno(String nombre, char sexo, long dni, long lu, String facultad, String carrera, int anioIngreso, int p1,
      int rP1, int p2, int rP2, int tPFinal) {
    super(nombre, sexo, dni, lu, facultad, carrera, anioIngreso, p1, rP1, p2, rP2, tPFinal);
  }

  @Override
  boolean estaAusente() {
    return this.P1 == 0 && this.RP1 == 0 && this.P2 == 0 && this.RP2 == 0 && this.TPFinal == 0;
  }

  @Override
  boolean estaLibre() {
    return (this.P1 < 60 && this.RP1 < 60) || (this.P2 < 60 && this.RP2 < 60) || this.TPFinal < 60;
  }

  @Override
  void showStudent() {
    System.out.println("Nombre: " + getNombre());
    String sexo = (getSexo() == 'M' || getSexo() == 'm') ? "Masculino" : "Femenino";
    System.out.println("Sexo: " + sexo);
    System.out.println("DNI: " + getDni());
    System.out.println("LU: " + this.LU);
    System.out.println("Facultad: " + this.facultad);
    System.out.println("Carrera: " + this.carrera);
    System.out.println("Anio de Ingreso: " + this.anioIngreso);
    System.out.println("=== Notas durante la cursada ===");
    System.out.print("Primer Parcial: " + this.P1);
    System.out.print("\tRecuperatorio del Primer Parcial: " + this.RP1);
    System.out.print("\tSegundo Parcial: " + this.P2);
    System.out.print("\tRecuperatorio del Segundo Parcial: " + this.RP2);
    System.out.println("\tTrabajo Practico Final: " + this.TPFinal);
  }

}
