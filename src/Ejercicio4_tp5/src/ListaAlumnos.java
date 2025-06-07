import java.util.ArrayList;

public class ListaAlumnos {
    private ArrayList<Alumno>alumnos;
    private int c;

    public ListaAlumnos(ArrayList<Alumno>alumnos){
        this.alumnos = alumnos;
        c=0;
    }

    public int cantRegulares(){
        c=0;
        for (int i=0;i<alumnos.size();i++){
            if(alumnos.get(i).estaRegular())
                c++;
        }
        return c;
    }

    public int cantLibres(){
        c=0;
        for (int i=0;i<alumnos.size();i++){
            if(alumnos.get(i).estaLibre())
                c++;
        }
        return c;
    }

    public int cantAusentes(){
        c=0;
        for (int i=0;i<alumnos.size();i++){
            if(alumnos.get(i).estaAusente())
                c++;
        }
        return c;
    }
}
