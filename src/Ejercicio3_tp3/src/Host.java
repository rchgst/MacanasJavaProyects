public class Host extends Conexion{
    private Red red;
    public Host(Direccion direccion){
        super(direccion);
    }

    public void conectar(Red red){
        this.red=red;
    }



}
