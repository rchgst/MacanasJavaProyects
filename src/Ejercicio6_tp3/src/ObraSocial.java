public class ObraSocial {
    private int cuit;
    private String denominacion,domicilio;

    public ObraSocial(int cuit,String denominacion,String domicilio){
        this.cuit = cuit;
        this.denominacion = denominacion;
        this.domicilio = domicilio;
    }

    public String getDenominacion() {
        return this.denominacion;
    }
}
