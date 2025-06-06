public class ColectivoDiesel extends Colectivo implements IDiesel{
    private double distancia,nivelContaminacion;

    public ColectivoDiesel(int capacidad,double costo,double distancia,double nivelContaminacion){
        super(capacidad,costo);
        this.distancia = distancia;
        this.nivelContaminacion = nivelContaminacion;
    }

    @Override
    public double getAcel() {
        return 3.0;
    }

    @Override
    public double getDistancia() {
        return this.distancia;
    }

    @Override
    public double getNivelContaminacion() {
        return this.nivelContaminacion;
    }

}
