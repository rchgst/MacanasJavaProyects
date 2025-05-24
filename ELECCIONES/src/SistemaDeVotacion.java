import java.util.ArrayList;

public class SistemaDeVotacion {
    private ArrayList<Partido> partidos;
    private ArrayList<Votante> padron;

    public SistemaDeVotacion(){
        this.partidos=new ArrayList<Partido>();
        this.padron= new ArrayList<Votante>();
    }
    public void agregarPartido(Partido nuevo) {
        this.partidos.add(nuevo);
        }
    public void agregarVotante(Votante nuevo){
        this.padron.add(nuevo);
    }
    public void muestraAlumnos(){
        ArrayList alumnosVotantes= new ArrayList<Alumno>();
        for(int i=0;i<this.padron.size();i++){
            if(this.padron.get(i)instanceof Alumno){
                if(this.padron.get(i).puedeVotar())
                    alumnosVotantes.add(this.padron.get(i));
            }
        }
        if(alumnosVotantes.size()==0)
            System.out.println("Lista de alumnos habilitados vacia");
        else{
            System.out.println("Alumnos habilitados a votar: \n");
            System.out.println(alumnosVotantes);
        }
    }
    public void muestraPorc(){
        int cantPVot=0, cantAVot=0,cantA=0,cantP=0;
        double porcA,porcD;
        for(int i=0;i<this.padron.size();i++){
            if(this.padron.get(i)instanceof Alumno){
                cantA++;
                if(this.padron.get(i).puedeVotar())
                    cantAVot++;
            }
            else{
                if (this.padron.get(i)instanceof Docente){
                    cantP++;
                    if(this.padron.get(i).puedeVotar())
                        cantPVot++;
                }
            }

        }
        porcA=(cantAVot*100.0)/cantA;
        porcD=(cantPVot*100.0)/cantP;
        System.out.println("PORCENTAJE DE ALUMNOS HABILITADOS A VOTAR "+porcA);
        System.out.println("\nPORCENTAJE DE PROFESORES HABILITADOS A VOTAR "+porcD);
    }
}
