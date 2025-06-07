class Student extends Person {
    long LU;
    String facultad;
    String carrera;
    int anioIngreso;

    Student(String vnombre, char vsexo, long vdni, long vlu, String vfacultad,
            String vcarrera, int vingreso) {
        super(vnombre, vsexo, vdni);
        LU = vlu;
        facultad = vfacultad;
        carrera = vcarrera;
        anioIngreso = vingreso;
    }

    long getLu() { return LU; }
}
