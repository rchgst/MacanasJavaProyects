import java.util.ArrayList;
public class TecnicoDT{
    ArrayList<String> Competencias;
    public TecnicoDT(){
        this.Competencias= new ArrayList<>();
    }

public void AgregaTorneo(String Torneo){
    Competencias.add(Torneo);
}
public void EliminaTorneo(String Torneo){
    Competencias.remove(Torneo);
}
public void EliminaTorneos(){
    Competencias.clear();
}
public int CantidadTorneos(){
    return Competencias.size();
}
public String toString(){
    String Texto="";
    int i;
    for(i=0;i<Competencias.size();i++){
        Texto+=Competencias.get(i)+"\n";
    }
    return Texto;
}
}