public class Surtidor {
  private int cargaMax;
  private int ultraDiesel;
  private int euroDiesel;
  private int naftaSuper;
  private int naftaInfinia;

  public Surtidor() {
    this.cargaMax = 20000;
    this.ultraDiesel = this.cargaMax;
    this.euroDiesel = this.cargaMax;
    this.naftaSuper = this.cargaMax;
    this.naftaInfinia = this.cargaMax;
  }

  public void llenarDepositoUDiesel() {
    System.out.println("Llenando el deposito de Ultra Diesel");
    this.ultraDiesel = this.cargaMax;
  }

  public void llenarDepositoEDiesel() {
    System.out.println("Llenando el deposito de Euro Diesel");
    this.euroDiesel = this.cargaMax;
  }

  public void llenarDepositoNSuper() {
    System.out.println("Llenando el deposito de Nafta Super");
    this.naftaSuper = this.cargaMax;
  }

  public void llenarDepositoInfinia() {
    System.out.println("Llenando el deposito de Nafta Infinia");
    this.naftaInfinia = this.cargaMax;
  }

  public int getCantUDiesel() {
    return this.ultraDiesel;
  }

  public int getCantEDiesel() {
    return this.euroDiesel;
  }

  public int getCantNSuper() {
    return this.naftaSuper;
  }

  public int getCantInfinia() {
    return this.naftaInfinia;
  }

  public void cargarUDiesel(int litros) {
    if (this.ultraDiesel >= litros) {
      this.ultraDiesel -= litros;
      System.out.println("Se han cargado " + litros + " de Ultra Diesel");
    } else {
      System.out.println("Faltaron llenar " + (litros - this.ultraDiesel) + " litros de combustible");
      this.ultraDiesel = 0;
    }
  }

  public void cargarEDiesel(int litros) {
    if (this.euroDiesel >= litros) {
      System.out.println("Se han cargado " + litros + " de Euro Diesel");
      this.euroDiesel -= litros;
    } else {
      System.out.println("Faltaron llenar " + (litros - this.euroDiesel) + " litros de combustible");
      this.euroDiesel = 0;
    }
  }

  public void cargarNSuper(int litros) {
    if (this.naftaSuper >= litros) {
      this.naftaSuper -= litros;
      System.out.println("Se han cargado " + litros + " de Nafta Super");
    } else {
      System.out.println("Faltaron llenar " + (litros - this.naftaSuper) + " litros de combustible");
      this.naftaSuper = 0;
    }
  }

  public void cargarInfinia(int litros) {
    if (this.naftaInfinia >= litros) {
      System.out.println("Se han cargado " + litros + " de Nafta Infinia");
      this.naftaInfinia -= litros;
    } else {
      System.out.println("Faltaron llenar " + (litros - this.naftaInfinia) + " litros de combustible");
      this.naftaInfinia = 0;
    }
  }
}
