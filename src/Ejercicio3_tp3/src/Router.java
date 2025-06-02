import java.util.ArrayList;

public class Router extends Conexion{
    private int puertos;
    private Router router;
    private Red red;


    public Router(Direccion direccion,int puertos){
        super(direccion);
        this.puertos = puertos;
    }

    public Router(){
        super();
        puertos = 0;
    }

    public void conectar(Router router){
        this.router = router;
    }

    public void conectar(Red red){
        this.red = red;
    }

}
