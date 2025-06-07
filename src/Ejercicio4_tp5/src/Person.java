public class Person {
    private String nombre;
    private char sexo;
    private long dni;

    Person(String vnombre, char vsexo, long vdni) {
        nombre = vnombre;
        sexo = vsexo;
        dni = vdni;
    }

    String getNombre() { return nombre; }
    char getSexo() { return sexo; }
    long getDni() { return dni; }
    void setNombre(String nombre) { this.nombre = nombre; }
}
