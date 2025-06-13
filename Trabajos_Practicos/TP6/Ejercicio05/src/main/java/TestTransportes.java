import java.util.ArrayList;

public class TestTransportes {
  public static void main(String[] args) {
    ArrayList<Transporte> transportes = new ArrayList<>();
    Jeep jeep = new Jeep("Gladiator", 5, 280, 4);
    Aerodeslizador aerodeslizador = new Aerodeslizador("Aero", 3, 400, 200, 4);
    Crucero crucero = new Crucero("Crux", 100, 400, 5000);
    transportes.add(jeep);
    transportes.add(aerodeslizador);
    transportes.add(crucero);
    for (Transporte transporte : transportes) {
      if (transporte instanceof TransporteTerrestre) {
        ((TransporteTerrestre) transporte).tocarBocina();
      }
    }
  }
}
