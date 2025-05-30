import java.util.ArrayList;
public class red {
    private Direccion ip;
    private ArrayList<host> linked;
    public red(ArrayList<host> conects,int x, int y){
        this.linked=conects;
        this.ip=new Direccion(x,y);
    }
    public Direccion getDireccion(){
        return this.ip;
    }
    public int getdirx(){
        return getDireccion().dirx();
    }
    public void ConexiondeHost(host pc){
        if(pc.ConexcionaRed(getdirx())){
            linked.add(pc);
        }

    }
    
}
