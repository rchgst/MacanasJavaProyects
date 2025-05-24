public class Main {
  public static void main(String[] args) {
    Tecnico tec = new Tecnico();
    tec.cargarCompetencia("Copa Cebollitas");
    tec.cargarCompetencia("Copa Libertadores");
    tec.cargarCompetencia("Torneo Villa Chica");
    tec.cargarCompetencia("Copa SudAmerica");
    System.out.println(tec);
    tec.eliminarCompetencia();
    System.out.println(tec);
    tec.eliminarCompetencia("Copa Libertadores");
    System.out.println(tec.cantidadDeCompetencias());
    System.out.println(tec);
  }
}
