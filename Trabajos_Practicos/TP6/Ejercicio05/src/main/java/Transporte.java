public interface Transporte {
  public abstract String getNombre();

  public abstract void setNombre(String nombre);

  public abstract int getMaxPasajeros();

  public abstract void setMaxPasajeros(int maxp);

  public abstract int getMaxVelocidad();

  public abstract void setMaxVelocidad(int maxv);
}
