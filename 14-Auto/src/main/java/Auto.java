public class Auto {
  private Motor motor;
  private Tanque tanque;
  private double distanciaRecorrida;

  public Motor getMotor() {
    return this.motor;
  }

  public void setMotor(Motor motor) {
    this.motor = motor;
  }

  public Tanque getTanque() {
    return this.tanque;
  }

  public void setTanque(Tanque tanque) {
    this.tanque = tanque;
  }

  public double getDistanciaRecorrida() {
    return this.distanciaRecorrida;
  }

  public void setDistanciaRecorrida(double distanciaRecorrida) {
    this.distanciaRecorrida = distanciaRecorrida;
  }

  public Auto() {
    this.motor = new Motor();
    this.tanque = new Tanque();
  }

  public Auto(Motor motor, Tanque tanque, double distanciaRecorrida) {
    this.motor = motor;
    this.tanque = tanque;
    this.distanciaRecorrida = distanciaRecorrida;
  }

  public void mover() {
    if (!(this.tanque.isVacio()) && this.tanque.getCapActual() > this.motor.getConsumoXMin()) {
      if (!(this.motor.isEncendido())) {
        this.motor.setEncendido(true);
      }
      this.tanque.setCapActual(this.tanque.getCapActual() - this.motor.getConsumoXMin());
      this.distanciaRecorrida += (this.motor.getDistanciaXLitro() * this.motor.getConsumoXMin());
    } else if (this.tanque.getCapActual() < this.motor.getConsumoXMin()) {
      this.motor.setEncendido(false);
      System.out.println("Se ha apagado el motor porque ya no hay suficiente gasolina para avanzar.");
    } else {
      System.out.println("El tanque está vacío! El auto no puede avanzar.");
    }
  }

  public void cargarNafta() {
    this.tanque.setCapActual(this.tanque.getCapTotal());
  }

  public void cargarNafta(double litros) {
    if (this.tanque.getCapTotal() - this.tanque.getCapActual() >= litros) {
      this.tanque.setCapActual(this.tanque.getCapActual() + litros);
    } else {
      System.out.println("Esa cantidad de litros excede la capacidad del tanque!");
    }
  }

}
