abstract class AbsStudent extends Student {
  int P1, RP1, P2, RP2, TPFinal;

  public AbsStudent(String nombre, char sexo, long dni, long lu, String facultad, String carrera, int anioIngreso,
      int p1, int rP1, int p2, int rP2, int tPFinal) {
    super(nombre, sexo, dni, lu, facultad, carrera, anioIngreso);
    this.P1 = p1;
    this.RP1 = rP1;
    this.P2 = p2;
    this.RP2 = rP2;
    this.TPFinal = tPFinal;
  }

  boolean estaRegular() {
    return (this.P1 >= 60 || this.RP1 >= 60) && (this.P2 >= 60 || this.RP2 >= 60) && this.TPFinal >= 6;
  }

  abstract boolean estaLibre();

  abstract boolean estaAusente();

  abstract void showStudent();
}
