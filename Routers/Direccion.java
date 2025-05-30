public class Direccion{
    private int dirx;
    private int diry;
    public Direccion(int x, int y){
        this.dirx=x;
        this.diry=y;
    }
    public int dirx(){
        return dirx;
    }
    @Override
    public String toString(){
        return dirx+"."+diry;
    }
}