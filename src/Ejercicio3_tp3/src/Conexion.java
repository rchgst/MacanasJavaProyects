public class Conexion {
    private Direccion direccion;

    public Conexion(Direccion direccion){
        this.direccion = direccion;
    }

    public Conexion(){
        direccion.setX(0);
        direccion.setY(0);
    }

    public Direccion getDireccion(){
        return direccion;
    }

}
