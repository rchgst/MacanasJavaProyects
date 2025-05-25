import java.util.ArrayList;

public class Tecnico {
    private String nombre;
    private ArrayList<String> competencias;

    public Tecnico (String nombre){
        this.competencias=new ArrayList<String>();
        this.nombre= nombre;
    }
    public void cargarCompetencia(String comp){
       if(this.competencias.size()<=4){
           if(!this.competencias.contains(comp)){
               this.competencias.add(comp);
           }
       }else
           System.out.println("Alcanzo las competencias maximas");
    }
    public void eliminarCompetencia(){
        this.competencias.removeLast();
    }
    public void eliminarCompetencia(String comp){
        this.competencias.remove(comp);
    }
    public int cantidadDeCompetencias( ){
        return this.competencias.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String toString(){
        String cadena = "";
        cadena+= "Nombre: "+ this.nombre+"\n"+"Cantidad de competencias: "+ cantidadDeCompetencias()+ "\n" ;
        for (int i = 0; i < this.competencias.size(); i++) {
            cadena+= "Competencia: "+ this.competencias.get(i)+"\n";
        }
        return cadena;
    }

}