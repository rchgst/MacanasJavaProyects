public class Vector {
  double[] vector;

  public double[] getVector() {
    return this.vector;
  }

  public void setVector(double[] vector) {
    this.vector = vector;
  }

  public Vector(double[] vector) {
    this.vector = vector;
  }

  public Vector(int tam) {
    this.vector = new double[tam];
  }

  public void insertarElem(double elem, int indice) {
    if (indice >= 0 && indice < this.vector.length) {
      this.vector[indice] = elem;
    }
  }

  public void mostrar() {
    for (int i = 0; i < this.vector.length; i++) {
      System.out.println("Vector[" + i + "]: " + this.vector[i]);
    }
  }
}
