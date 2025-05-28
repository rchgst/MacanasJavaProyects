import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Autor> autores1 = new ArrayList<Autor>();
    ArrayList<Autor> autores2 = new ArrayList<Autor>();
    ArrayList<Autor> autores3 = new ArrayList<Autor>();
    ArrayList<Autor> autores4 = new ArrayList<Autor>();
    ArrayList<Autor> autores5 = new ArrayList<Autor>();
    Autor autor1 = new Autor("Juan Estebanez");
    Autor autor2 = new Autor("Mario Baracus");
    Autor autor3 = new Autor("Sebastian Henriquez");
    autores1.add(autor1);
    autores1.add(autor2);
    autores2.add(autor3);
    autores2.add(autor2);
    autores3.add(autor1);
    autores3.add(autor3);
    autores4.add(autor1);
    autores5.add(autor3);
    Papel formato1 = new Papel("tapa dura");
    Papel formato2 = new Papel("tapa blanda");
    Digital formato3 = new Digital("mobi");
    Digital formato4 = new Digital("pdf");
    Libro libro1 = new Libro(1, autores1, formato1, 200);
    Libro libro2 = new Libro(2, autores2, formato2, 350);
    Libro libro3 = new Libro(3, autores3, formato3, 110);
    Libro libro4 = new Libro(4, autores4, formato4, 100);
    Libro libro5 = new Libro(5, autores5, formato2, 280);
    TipoDePago pago1 = new Efectivo();
    TipoDePago pago2 = new TarjetaDeCredito();
    TipoDePago pago3 = new MercadoPago();
    CarritoDeCompra carrito1 = new CarritoDeCompra();
    carrito1.agregarLibro(libro1);
    carrito1.agregarLibro(libro2);
    carrito1.agregarLibro(libro3);
    carrito1.agregarLibro(libro4);
    carrito1.agregarLibro(libro5);
    carrito1.pagar(pago1);
    carrito1.pagar(pago2);
    carrito1.pagar(pago3);
  }
}
