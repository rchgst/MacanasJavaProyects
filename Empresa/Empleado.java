public class Empleado{
    protected String nombre;
    protected String Documento;
    protected String Direccion;
    protected int AñoAntiguedad;
    protected String Telefono;
    protected double Salario;
    
    public Empleado(){
    this.nombre="";
    this.Documento="";
    this.Direccion="";
    this.AñoAntiguedad=0;
    this.Telefono="";
    this.Salario=0;
    }
    public Empleado (String nombre, String Documento, String Direccion, int AñoAntiguedad, String Telefono, double Salario){
    this();
    this.nombre=nombre;
    this.Documento=Documento;
    this.Direccion=Direccion;
    this.AñoAntiguedad=AñoAntiguedad;
    this.Telefono=Telefono;
    this.Salario=Salario;
    }   
    public double GetSalario(){
        return this.Salario;
    }
    public void SetSalario(double Salario){
        this.Salario=Salario;
    }
    public String toString(){
        return "Nombre: "+this.nombre+"Documento: "+this.Documento+"Direccion: "+this.Direccion+"Años de Antiguedad: "+this.AñoAntiguedad+"Telefono: "+this.Telefono+"Salario: "+this.Salario;
    }
    public void SueldoPorAntiguedad(int Añoantiguedad){
        SetSalario(GetSalario()*12+(this.AñoAntiguedad*10000));
    }
}