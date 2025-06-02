import java.util.ArrayList;

public class Red extends Conexion{
    private ArrayList<Host> hosts;
    private Router router;

    public Red(Direccion direccion){
        super(direccion);
        hosts = new ArrayList<>(0);
        router = new Router();
    }

    public void conectar(Host host){
        hosts.add(host);
    }

    public void conectar(Router router){
        this.router = router;
    }



}
