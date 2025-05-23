public class Coche {
    private String matricula;
    private String modelo;
    private String marca;

    public Coche(String matri, String model, String marca){
        this.matricula = matri;
        this.modelo = model;
        this.marca = marca;
    }

    public String toString(){
        return "Auto: Matricula: " + this.matricula + " Modelo: " + this.modelo + " Marca: " + this.marca;
    }
}