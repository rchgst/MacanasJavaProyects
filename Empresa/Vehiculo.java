public class Vehiculo{
    public String Matricula;
    public String Marca;
    public String Modelo;

    public Vehiculo(){
        this.Matricula="";
        this.Marca="";
        this.Modelo="";
    }
    public Vehiculo(String Matricula, String Marca, String Modelo){
        this.Matricula=Matricula;
        this.Marca=Marca;
        this.Modelo=Modelo;
    }
    public String toString(){
        return "Matricula: \n"+this.Matricula+"Marca: \n"+this.Marca+"Modelo: "+this.Modelo;
    }
}   