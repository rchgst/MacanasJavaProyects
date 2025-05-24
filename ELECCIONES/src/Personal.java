public class Personal extends Votante {
    public Personal(String nombre,long dni){
        super(nombre,dni);
    }
    @Override
    public boolean puedeVotar() {
        return true;
    }
}
