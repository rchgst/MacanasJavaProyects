public class Hibrido extends Colectivo implements IDiesel,IElectrico{
    private double voltaje,distancia,nivelContaminacion;


    public Hibrido(int capacidad, double costo,double voltaje,double distancia,double nivelContaminacion) {
        super(capacidad, costo);
        this.voltaje = voltaje;
        this.distancia = distancia;
        this.nivelContaminacion = nivelContaminacion;
    }

    @Override
    public double getAcel() {
        return 4.0;
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
    public double getVoltaje() {
        return this.voltaje;
    }

    @Override
    public double getAltoVoltaje() {
        return this.voltaje;
    }

    @Override
    public double getBajoVoltaje() {
        return this.voltaje;
    }
}
