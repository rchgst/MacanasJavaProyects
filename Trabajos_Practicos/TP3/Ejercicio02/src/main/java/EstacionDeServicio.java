import java.util.ArrayList;

public class EstacionDeServicio {
  private int m;
  private ArrayList<Surtidor> surtidores;

  public EstacionDeServicio() {
    this.surtidores = new ArrayList<>();
  }

  public EstacionDeServicio(int m) {
    this();
    this.m = m;
    for (int i = 0; i < m; i++) {
      this.surtidores.add(new Surtidor());
    }
  }

  public int getM() {
    return this.m;
  }

  public void reponerDepositos(int gasolina) {
    switch (gasolina) {
      case 1:
        for (Surtidor surtidor : this.surtidores) {
          surtidor.llenarDepositoUDiesel();
        }
        break;
      case 2:
        for (Surtidor surtidor : this.surtidores) {
          surtidor.llenarDepositoEDiesel();
        }
        break;
      case 3:
        for (Surtidor surtidor : this.surtidores) {
          surtidor.llenarDepositoNSuper();
        }
        break;
      case 4:
        for (Surtidor surtidor : this.surtidores) {
          surtidor.llenarDepositoInfinia();
        }
        break;
      default:
        System.out.println("No es una opcion valida la ingresada");
        break;
    }
  }

  public void cargarNSuper(int surtidor, int litros) {
    if (surtidor >= 0 && surtidor <= this.m) {
      this.surtidores.get(surtidor).cargarNSuper(litros);
    } else {
      System.out.println("Numero de surtidor invalido!");
    }
  }

  public void cargarUDiesel(int surtidor, int litros) {
    if (surtidor >= 0 && surtidor <= this.m) {
      this.surtidores.get(surtidor).cargarUDiesel(litros);
    } else {
      System.out.println("Numero de surtidor invalido!");
    }
  }

  public void cargarEDiesel(int surtidor, int litros) {
    if (surtidor >= 0 && surtidor <= this.m) {
      this.surtidores.get(surtidor).cargarEDiesel(litros);
    } else {
      System.out.println("Numero de surtidor invalido!");
    }
  }

  public void cargarInfinia(int surtidor, int litros) {
    if (surtidor >= 0 && surtidor <= this.m) {
      this.surtidores.get(surtidor).cargarInfinia(litros);
    } else {
      System.out.println("Numero de surtidor invalido!");
    }
  }

  public void mostrarCapActSurtidores() {
    for (Surtidor surtidor : this.surtidores) {
      System.out.println("=== Cantidad de combustible del surtidor ===");
      System.out.println("Ultra Diesel: " + surtidor.getCantUDiesel());
      System.out.println("Euro Diesel: " + surtidor.getCantEDiesel());
      System.out.println("Nafta Super: " + surtidor.getCantNSuper());
      System.out.println("Nafta Infinia: " + surtidor.getCantInfinia());
    }
  }
}
