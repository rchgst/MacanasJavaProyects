import java.util.ArrayList;

public class CajaRegistradora {
  private int numeroId;
  private double recaudacion;
  private ArrayList<Movimiento> movimientos;

  public int getNumeroId() {
    return this.numeroId;
  }

  public double getRecaudacion() {
    return this.recaudacion;
  }

  public ArrayList<Movimiento> getMovimientos() {
    return this.movimientos;
  }

  public CajaRegistradora(int numeroId) {
    this();
    this.numeroId = numeroId;
  }

  public CajaRegistradora() {
    this.movimientos = new ArrayList<>();
  }

  public void agregarMovimiento(Movimiento mov) {
    this.movimientos.add(mov);
    this.recaudacion += mov.getImporte();
  }

}
