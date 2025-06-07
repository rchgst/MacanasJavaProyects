public class Alumno extends AbsStudent{

    public Alumno(String vnombre, char vsexo, long vdni, long vlu, String vfacultad, String vcarrera, int vingreso, int vP1, int vRP1, int vP2, int vRP2, int vTPFinal) {
        super(vnombre, vsexo, vdni, vlu, vfacultad, vcarrera, vingreso, vP1, vRP1, vP2, vRP2, vTPFinal);
    }

    public boolean estaLibre(){
        boolean primerParcial = this.P1<60 && this.RP1<60;
        boolean segundoParcial = this.P2<60 && this.RP2<60;
        boolean tpFinal = this.TPFinal < 60;
        return primerParcial || segundoParcial || tpFinal;
    }
    public boolean estaAusente(){
        return this.P1 == 0 && this.RP1 == 0 && this.P2 == 0 && this.RP2 == 0;
    }
    public void showStudent(){
        System.out.println();
        System.out.println("nombre: "+this.getNombre());
        System.out.println("sexo: "+this.getSexo());
        System.out.println("DNI: "+this.getDni());
        System.out.println("libreta universitaria: "+this.getLu());
        System.out.println("facultad: "+this.facultad+" carrera: "+this.carrera+" año de ingreso: "+this.anioIngreso);
        System.out.println("notas de los parciales y/o trabajo final");
        System.out.println("primer parcial: "+this.P1+" recuperatorio del primer parcial: "+this.RP1+" segundo parcial: "+this.P2+" recuperatorio segundo parcial: "+this.RP2+" trabajo final: "+this.TPFinal);
    }

}
