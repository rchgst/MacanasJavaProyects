abstract class AbsStudent extends Student {
    int P1, RP1, P2, RP2, TPFinal;

    AbsStudent(String vnombre, char vsexo, long vdni, long vlu, String vfacultad,
               String vcarrera, int vingreso, int vP1, int vRP1, int vP2, int vRP2, int vTPFinal) {
        super(vnombre, vsexo, vdni, vlu, vfacultad, vcarrera, vingreso);
        P1 = vP1;
        P2 = vP2;
        RP1 = vRP1;
        RP2 = vRP2;
        TPFinal = vTPFinal;
    }

    boolean estaRegular() {
        boolean rta = false;
        if (((P1 >= 60) || (RP1 >= 60)) && ((P2 >= 60) || (RP2 >= 60)) && (TPFinal >= 6)) {
            rta = true;
        }
        return rta;
    }

    abstract boolean estaLibre();
    abstract boolean estaAusente();
    abstract void showStudent();
}
