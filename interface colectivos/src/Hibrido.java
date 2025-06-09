public class Hibrido extends Colectivo implements IElectrico,IDiesel{
    private double voltaje;
    private double distancia;
    private double nivelContaminacion;
    public Hibrido(int capacidad,double costo,double voltaje,double distancia,double contaminacion){
        super(capacidad,costo);
        this.voltaje=voltaje;
        this.distancia=distancia;
        this.nivelContaminacion=contaminacion;
    }

    @Override
    public double getDistancia() {
        return this.distancia;
    }

    @Override
    public double getNivelContaminacion() {
        return this.nivelContaminacion;
    }

    @Override
    public double getAcel() {
        return 4.0;
    }

    @Override
    public double getVoltaje() {
        return this.voltaje;
    }
}
