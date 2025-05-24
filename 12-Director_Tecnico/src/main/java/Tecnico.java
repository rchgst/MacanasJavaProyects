import java.util.ArrayList;

public class Tecnico {
  private ArrayList<String> competencias;
  private int limiteCompetencias;

  public Tecnico() {
    this.competencias = new ArrayList<>();
    this.limiteCompetencias = 4;
  }

  public void cargarCompetencia(String competencia) {
    if (this.competencias.size() < this.limiteCompetencias) {
      this.competencias.add(competencia);
    } else {
      System.out.println("No se pueden agregar mas competencias!");
    }
  }

  public void eliminarCompetencia() {
    if (this.competencias.size() > 0) {
      this.competencias.removeLast();
    } else {
      System.out.println("La lista esta vacia, no es posible eliminar competencias.");
    }
  }

  public void eliminarCompetencia(String competencia) {
    if (this.competencias.contains(competencia)) {
      this.competencias.remove(competencia);
    } else {
      System.out.println("La competencia no se encuentra en la lista de competencias.");
    }
  }

  public int cantidadDeCompetencias() {
    return this.competencias.size();
  }

  @Override
  public String toString() {
    String cadena = "Tecnico\n===Competencias===\n";
    if (this.competencias.size() > 0) {
      for (String string : this.competencias) {
        cadena += string + "\n";
      }
    } else {
      cadena += "No hay competencias!";
    }
    return cadena;
  }

}
