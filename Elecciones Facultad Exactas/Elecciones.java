import java.util.ArrayList;
public class Elecciones{
    private String NombreEleccion;
    private ArrayList<Candidatos> Candidato;
    private ArrayList<Alumno> Alumnos;
    private ArrayList<Docente> Docentes;
    private ArrayList<Personal> Personals;
    public Elecciones(){
        this.NombreEleccion="";
        this.Candidato=new ArrayList<>();
        this.Alumnos=new ArrayList<>();
        this.Docentes=new ArrayList<>();
        this.Personals=new ArrayList<>();
    }   
    public void AgregaCandidatos(Candidatos Candicato){
        this.Candidato.add(Candicato);
    }
    public void AgregaAlumnmo(Alumno Alumnos){
        this.Alumnos.add(Alumnos);
    }
    public void AgregaDocente(Docente Docentes){
        this.Docentes.add(Docentes);
    }
    public void AgregaPersonal(Personal Personals){
        this.Personals.add(Personals);  
    }
    public ArrayList<Alumno> VerificaAptos(ArrayList<Alumno> Alumnos){
        int i=0;
        while(i<this.Alumnos.size()){
            if(Alumnos.get(i).AptoParaVotar==false){
                Alumnos.remove(i);
            }
            i++;
        }
        return Alumnos;
    }


    public String GetNombreEleccion(){
        return this.NombreEleccion;
    }   
    public void SetNombreEleccion(String NombreEleccion){
        this.NombreEleccion=NombreEleccion;
    }
    public int DevuelveAptosAlumnos(ArrayList<Alumno> Alumnos){
        int Aptos=0, i;
        for(i=0;i<this.Alumnos.size();i++){
            if(this.Alumnos.get(i).AptoParaVotar==true){
                Aptos++;
            }
            
        }
        return Aptos;
    }
    public int DevuelveAptosDocentes(ArrayList<Docente> Docentes){
        int Aptos=0, i;
        for(i=0;i<this.Docentes.size();i++){
            if(this.Docentes.get(i).esAptoParaVotar()==true){
                Aptos++;
            }
            
        }
        return Aptos;
    }
    public int CuantosvotanAlu(){
       
        return DevuelveAptosAlumnos(this.Alumnos)  /this.Alumnos.size()*100;
    }
    public int CuantosvotanDoc(){

        return DevuelveAptosDocentes(this.Docentes)  /this.Docentes.size()*100;
    }

}