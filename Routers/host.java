public class host {
    private boolean linking;
    private Direccion ip;
    public host(int x,int y){
        this.ip= new Direccion(x, y);
        this.linking=false;
    }
    public Direccion getDireccion(){
        return this.ip;
    }
    public int getdirx(){
        return getDireccion().dirx();
    }
    public boolean ConexcionaRed(int dirx){
        if(ip.dirx()==dirx){
            this.linking=true;
            return true;
        }
        return false;
    }
    @Override
    public String toString(){
        return ip+"\t"+"Esta conectado? "+linking;
    }
}
