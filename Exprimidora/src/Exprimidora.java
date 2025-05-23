public class Exprimidora {
    protected String nombre;

    public Exprimidora(){
        this.nombre = "H2025";
    }

    public static double exprimir(Vegetal veg){
        double jugo;
        jugo = (veg.peso * veg.getPorcentajeJugo()) - veg.getPesoExtra();
        return jugo;
    }
}
