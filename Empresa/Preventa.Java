

public class Preventa extends Empleado{
    public Vehiculo vehiculo;
    public int Celular;

    public Preventa(){
        super();
        this.vehiculo = new Vehiculo();
        this.Celular=0;
    }
    public Preventa(String nombre,String Documento,String Direccion,int AñoAntiguedad, String Telefono, double, Salario, int Celular, String Matricula, String Marca, Stringa Modelo){
        super(nombre,Documento,DireccionAñoAntiguedad,Telefono,Salario);
        this.vehiculo= new Vehiculo(Matricula,Marca,Modelo);
        this.Celular=Celular;
    }
    public String toString(){
        return super.toString()+"Celular: "+this.Celular+"vehiculo: "+ this.vehiculo;
    }
    @Override
        public void SueldoPorAntiguedad(int AñoAntiguedad){
         if(this.SerEmpleado==true){
            SetSalario((GetSalario()*12)*0.0002+(this.AñoAntiguedad*12000));
        }
    }
}