public class ColectivoElectrico extends Colectivo implements IElectrico {
    private double voltaje;
    public ColectivoElectrico(int capacidad,double costo,double voltaje){
        super(capacidad,costo);
        this.voltaje=voltaje;
    }
    @Override
    public double getAcel() {
        return 5.0;
    }

    @Override
    public double getVoltaje() {
        return this.voltaje;
    }
}
