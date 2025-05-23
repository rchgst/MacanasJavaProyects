import java.util.ArrayList;

public class Exprimidora {
  private ArrayList<Vegetal> vegetales;
  private String modelo;

  public String getModelo() {
    return this.modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public Exprimidora() {
    this.vegetales = new ArrayList<>();
  }

  public Exprimidora(String modelo) {
    this();
    this.modelo = modelo;
  }

  public Exprimidora(String modelo, ArrayList<Vegetal> vegetales) {
    this(modelo);
    this.vegetales = vegetales;
  }

  public void agregarVegetal(Vegetal veg) {
    this.vegetales.add(veg);
  }

  public void eliminarVegetal(Vegetal veg) {
    this.vegetales.remove(veg);
  }

  public void exprimirVegetal(Vegetal veg) {
    System.out.println("Se ha exprimido el vegetal! Ha conseguido " + veg.calcularCantidadJugo() + "ml de jugo de "
        + String.valueOf(veg.getClass()));
  }

  public void exprimirVegetal(String veg) {
    for (Vegetal vegetal : vegetales) {
      if (vegetal.getClass().getSimpleName().equals(veg)) {
        System.out.println("Exprimiendo " + veg);
        System.out.println("Se obtuvo " + vegetal.calcularCantidadJugo() + "ml de jugo. Disfrute!");
        break;
      }
    }
  }

  public void exprimirVegetales(String veg) {
    System.out.println("Se exprimiran todos los vegetales de la lista que sean: " + veg);
    double jugoTotal = 0;
    for (Vegetal vegetal : vegetales) {
      if (vegetal.getClass().getSimpleName().equals(veg)) {
        jugoTotal += vegetal.calcularCantidadJugo();
      }
    }
    if (jugoTotal > 0) {
      System.out.println("Se han exprimido " + jugoTotal + "ml de jugo de " + veg);
    } else {
      System.out.println("No habia ese vegetal disponible. Compre " + veg + "!");
    }
  }

  public void cargarListaVegetales() {
    Jengibre jen = new Jengibre(100);
    Manzana man = new Manzana(250);
    Naranja nar = new Naranja(200);
    Pera per = new Pera(250);
    Remolacha rem = new Remolacha(150);
    Tomate tom = new Tomate(180);
    Zanahoria zan = new Zanahoria(100);
    this.vegetales.add(jen);
    this.vegetales.add(man);
    this.vegetales.add(nar);
    this.vegetales.add(per);
    this.vegetales.add(rem);
    this.vegetales.add(tom);
    this.vegetales.add(zan);
  }

  public static void main(String[] args) {
    Exprimidora ex = new Exprimidora("H2025");
    ex.cargarListaVegetales();
    ex.exprimirVegetal("Tomate");
    Naranja nar1 = new Naranja(130);
    Naranja nar2 = new Naranja(110);
    Naranja nar3 = new Naranja(120);
    ex.agregarVegetal(nar1);
    ex.agregarVegetal(nar2);
    ex.agregarVegetal(nar3);
    Tomate tom1 = new Tomate(150);
    ex.exprimirVegetal(tom1);
    ex.exprimirVegetales("Naranja");
  }
}
