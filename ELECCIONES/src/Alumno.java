public class Alumno extends Votante{
    private int matAprobadasUltAnio;

    public Alumno(String nombre,long dni,int matAprobadasUltAnio){
        super(nombre,dni);
        this.matAprobadasUltAnio=matAprobadasUltAnio;
    }
    public boolean puedeVotar(){
        if(this.matAprobadasUltAnio>=2)
            return true;
        else
            return false;
    }
    public void votar(Partido electo){
        electo.setCantVotos(1);
    }
}
