public class MetododePago{
    public boolean ValidaPago(double Monto){
        if((Monto>0)){
            return true;
        }
        else{
            return false;
        }
    }
}