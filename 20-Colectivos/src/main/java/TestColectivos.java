import java.util.ArrayList;

public class TestColectivos {
  public static void main(String[] args) {
    ColectivoHibrido ch = new ColectivoHibrido(45, 1.2, IElectrico.ALTO_VOLTAJE, 150, 2);
    ColectivoDiesel ci = new ColectivoDiesel(50, 1, 200, 2);
    ArrayList<Colectivo> arr = new ArrayList<>();
    arr.add(ch);
    arr.add(ci);
    for (Colectivo colectivo : arr) {
      System.out.println("ID: " + colectivo.getID());
      if (colectivo instanceof ColectivoDiesel) {
        ColectivoDiesel cole = (ColectivoDiesel) colectivo;
        System.out.println("Nivel de contaminacion: " + cole.getNivelContaminacion());
      } else {
        ColectivoHibrido cole = (ColectivoHibrido) colectivo;
        System.out.println("Nivel de contaminacion: " + cole.getNivelContaminacion());
      }
    }
    ColectivoElectrico ce = new ColectivoElectrico(55, 0.9, IElectrico.BAJO_VOLTAJE);
    arr.add(ce);
    for (Colectivo colectivo : arr) {
      System.out.println("ID: " + colectivo.getID());
      if (colectivo instanceof IElectrico) {
        System.out.println("Voltaje del colectivo: " + ((IElectrico) colectivo).getVoltaje());
      }
      if (colectivo instanceof IDiesel) {
        System.out.println("Nivel de contaminacion: " + ((IDiesel) colectivo).getNivelContaminacion());
      }
    }
  }
}
