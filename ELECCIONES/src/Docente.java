public class Docente extends Votante{
    private boolean cargoRegularEnAsign;
    public boolean puedeVotar(){
        return this.cargoRegularEnAsign;
    }
    public Docente(long dni,String nombre, boolean cargoRegularEnAsign){
        super(nombre,dni);
        this.cargoRegularEnAsign=cargoRegularEnAsign;
    }
}
