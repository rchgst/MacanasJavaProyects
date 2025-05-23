public class Exprimidora {
    private String nombre;

    public Exprimidora(){
        this.nombre="H2025";
    }
    public double extraerJugo(Vegetales vegetal){
        return vegetal.calulaJugo();
    }
}
