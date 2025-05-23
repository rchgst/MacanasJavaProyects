
public class Test {
    public static void main(String[] args) {
        PrecipitacionAnual clima=new PrecipitacionAnual();
        clima.PrecipActual(12.5);
        clima.PrecipActual(15.0);
        clima.PrecipActual(10.0);
        clima.PrecipActual(8.0);
        
        clima.SetPrecipMes(2, 16.6);

        clima.CalcularPromedioActual();
        clima.SetPrecipMes(4,32.3 );
        clima.SetPrecipMes(5,32.3 );
        clima.SetPrecipMes(6,17.3 );
        clima.SetPrecipMes(7,34.3 );
        clima.SetPrecipMes(8,37.3 );
        clima.SetPrecipMes(9,22.3 );
        clima.SetPrecipMes(10,35.3 );
        clima.SetPrecipMes(11,38.3 );
        clima.CalcularPromedioAnual();
        clima.CalcularListaDesvios();
    }
    
}