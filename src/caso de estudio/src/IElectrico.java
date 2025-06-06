public interface IElectrico {
    public static final double ALTO_VOLTAJE = 600;
    public static final double BAJO_VOLTAJE = 480;
    public abstract double getVoltaje();
    public abstract double getAltoVoltaje();
    public abstract double getBajoVoltaje();
}
