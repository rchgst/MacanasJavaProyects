import java.util.ArrayList;

public class Sucursal {
  private String nombre;
  private TablaLibros librosEnSuc;
  private TablaPrestamo librosPrestados;
  private TablaAutores totalidadAutores;

  public void prestarLibro(Libro l, Sucursal s) {
    if (this.librosEnSuc.existeLibro(l)) {
      if (!(this.librosPrestados.estaPrestado(l))) {
        Fecha fecha = new Fecha();
        fecha.sumarUnMes();
        this.librosPrestados.nuevoPrestamo(new Prestamo(l, s, fecha));
      } else {
        System.out.println("Ese libro ya se encuentra prestado!");
      }
    } else {
      System.out.println("No se encuentra ese libro en la sucursal.");
    }
  }

  public TablaLibros librosNacionalidad(String nac) {
    TablaLibros librosNac = null;
    TablaLibros librosAutor = null;
    TablaAutores autoresNac = this.totalidadAutores.autoresNac(nac);
    ArrayList<Libro> libros = null;
    if (autoresNac.cantidadAutores() > 0) {
      librosNac = new TablaLibros();
      for (int i = 0; i < autoresNac.cantidadAutores(); i++) {
        librosAutor = this.librosEnSuc.librosAutor(autoresNac.recuperarAutor(i).getNombre());
        libros = librosAutor.getLibros();
        for (Libro libro : libros) {
          librosNac.insertarLibro(libro);
        }
      }
    }
    return librosNac;
  }

  public double montoAseguradoPorAutor(String nombre) {
    TablaLibros librosAutor = this.librosEnSuc.librosAutor(nombre);
    double montoAsegurado = 0;
    if (librosAutor != null) {
      ArrayList<Libro> libros = new ArrayList<>();
      for (Libro libro : libros) {
        montoAsegurado += libro.montoAsegurado();
      }
    }
    return montoAsegurado;
  }

  public TablaLibros mayorMontoAsegurado(int n) {
    TablaLibros mayorMontoAsegurado = null;
    if (n > 0) {
      ArrayList<Libro> libros = this.librosEnSuc.getLibros();
      double mayor = libros.get(0).montoAsegurado();
      mayorMontoAsegurado = new TablaLibros();
      for (Libro libro : libros) {
        if (libro.montoAsegurado() > mayor) {
          mayor = libro.montoAsegurado();
        }
      }
      for (Libro libro : libros) {
        if (libro.montoAsegurado() == mayor && mayorMontoAsegurado.cantidadLibros() < n) {
          mayorMontoAsegurado.insertarLibro(libro);
        }
      }
    }
    return mayorMontoAsegurado;
  }

  public TablaAutores autoresPopulares(int n) {
    TablaAutores autoresPopulares = null;
    if (this.librosEnSuc.cantidadLibros() > 0) {
      autoresPopulares = new TablaAutores();
      ArrayList<Libro> libros = new ArrayList<>();
      for (int i = 0; i < this.totalidadAutores.cantidadAutores(); i++) {
        libros = this.librosEnSuc.librosAutor(this.totalidadAutores.recuperarAutor(i).getNombre()).getLibros();
        if (libros.size() > n) {
          for (Libro libro : libros) {
            if (this.librosPrestados.estaPrestado(libro) && !(autoresPopulares.estaAutor(libro.getAutor()))) {
              autoresPopulares.insertarAutor(libro.getAutor());
            }
          }
        }
      }
    }
    return autoresPopulares;
  }

  public Autor autorLibroMayorPeso() {
    Autor autorLibroMayorPeso = null;
    if (this.librosEnSuc.cantidadLibros() > 0) {
      ArrayList<Libro> libros = this.librosEnSuc.getLibros();
      Fisico libroFisico = null;
      int mayorPeso = 0;
      for (Libro libro : libros) {
        if (libro instanceof Fisico) {
          libroFisico = (Fisico) libro;
          if (libroFisico.getPeso() > mayorPeso) {
            mayorPeso = libroFisico.getPeso();
          }
        }
      }
      for (Libro libro : libros) {
        if (libro instanceof Fisico) {
          libroFisico = (Fisico) libro;
          if (libroFisico.getPeso() == mayorPeso) {
            autorLibroMayorPeso = libroFisico.getAutor();
          }
        }
      }
    }
    return autorLibroMayorPeso;
  }
}
