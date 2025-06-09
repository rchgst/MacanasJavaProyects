public class Direccion {
  private int x;
  private int y;

  public int getX() {
    return this.x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return this.y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Direccion(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Direccion() {
  }

  @Override
  public String toString() {
    return "Direccion: " + x + "." + y + "\n";
  }
}
