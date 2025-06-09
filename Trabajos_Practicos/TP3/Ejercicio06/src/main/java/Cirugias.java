import java.util.ArrayList;

public class Cirugias {
  private ArrayList<Cirugia> cirugias;
  private int cantidad;

  public void insertarCirugia(Cirugia cirugia) {
    if (!(this.cirugias.isEmpty())) {
      int i = this.cantidad;
      while (i > 0
          && this.cirugias.get(i - 1).getFchRealizacion().compararFechas(cirugia.getFchRealizacion()) > 0) {
        --i;
      }
      if (i == this.cantidad) {
        this.cirugias.add(cirugia);
      } else {
        this.cirugias.add(i, cirugia);
      }
    } else {
      this.cirugias.add(cirugia);
    }
    ++this.cantidad;
  }

  public void eliminarCirugia(String oSocial) {
    if (!(this.cirugias.isEmpty())) {
      int i = this.cantidad - 1;
      while (i >= 0) {
        if (this.cirugias.get(i).getPaciente().getObraSocial().getDenominacion().equals(oSocial)) {
          this.cirugias.remove(i);
          --this.cantidad;
        }
        --i;
      }
    } else {
      System.out.println("La lista esta vacia!");
    }
  }

  public double promedioDuracion() {
    double suma = 0;
    if (this.cantidad > 0) {
      for (Cirugia cirugia : this.cirugias) {
        suma += cirugia.getMinutosDuracion();
      }
      return suma / this.cantidad;
    }
    return 0;
  }

  public double promedioDuracion(Fecha desde, Fecha hasta) {
    double promedio = 0;
    if (this.cantidad > 0 && this.cirugias.getLast().getFchRealizacion().compararFechas(desde) > 0) {
      double suma = 0;
      int contador = 0;
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getFchRealizacion().compararFechas(desde) >= 0
            && cirugia.getFchRealizacion().compararFechas(hasta) <= 0) {
          suma += cirugia.getMinutosDuracion();
          ++contador;
        }
      }
      promedio = suma / contador;
    }
    return promedio;
  }

  public double promedioDuracion(int edad) {
    double promedio = 0;
    if (this.cantidad > 0) {
      double suma = 0;
      int contador = 0;
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getPaciente().edad() == edad) {
          suma += cirugia.getMinutosDuracion();
          ++contador;
        }
      }
      promedio = suma / contador;
    }
    return promedio;
  }

  public Cirugias cirugiasPrestador(String nombre) {
    Cirugias cirugiasPrestador = null;
    if (this.cantidad > 0) {
      cirugiasPrestador = new Cirugias();
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getPrestador().getNombre().equals(nombre)) {
          cirugiasPrestador.insertarCirugia(cirugia);
        }
      }
    }
    return cirugiasPrestador;
  }

  public Cirugias cirugiasOS(String os) {
    Cirugias cirugiasOS = null;
    if (this.cantidad > 0) {
      cirugiasOS = new Cirugias();
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getPaciente().getObraSocial().getDenominacion().equals(os)) {
          cirugiasOS.insertarCirugia(cirugia);
        }
      }
    }
    return cirugiasOS;
  }

  public Cirugias cirugiasPcte(Paciente p) {
    Cirugias cirugiasPcte = null;
    if (this.cantidad > 0) {
      cirugiasPcte = new Cirugias();
      for (Cirugia cirugia : this.cirugias) {
        if (cirugia.getPaciente().equals(p)) {
          cirugiasPcte.insertarCirugia(cirugia);
        }
      }
    }
    return cirugiasPcte;
  }

  public Cirugias() {
    this.cirugias = new ArrayList<>();
  }

  @Override
  public String toString() {
    String cadena = "";
    for (Cirugia cirugia : this.cirugias) {
      cadena += cirugia.toString();
    }
    return cadena;
  }
}
