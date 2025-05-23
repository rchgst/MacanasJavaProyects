import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;  
  public class Becario extends Empleado{
        public LocalDateTime FechaIngreso;
        public LocalDateTime FechaSalida;
        public boolean SerEmpleado;
    public Becario(){
        super();
        this.FechaIngreso=LocalDateTime.now();
        this.FechaSalida=LocalDateTime.now().plusDays((int)Math.random()+90);
        this.SerEmpleado=false;
    }
    public Becario(String nombre, String Documento, String Direccion, int AñoAntiguedad, String Telefono, double Salario, LocalDateTime FechaIngreso, LocalDateTime FechaSalida, boolean SerEmpleado){
        super(nombre,Documento,Direccion,AñoAntiguedad,Telefono,Salario);
        this.FechaIngreso=FechaIngreso;
        this.FechaSalida=FechaSalida;
    }   
    public LocalDateTime GetFechaIngreso(){
        return this.FechaIngreso;
    }
    public LocalDateTime GetFechaSalida(){
        return this.FechaSalida;
    }
    public boolean FechaVencida(LocalDateTime FechaIngreso, LocalDateTime FechaSalida){

        if(ChronoUnit.DAYS.between(FechaIngreso,FechaSalida)>=90){
            return true;
        }    
        else{
            return false;
        }
    }
    public void SerEmpleado(){
        if (this.FechaVencida(this.FechaIngreso,this.FechaSalida)==true){
            boolean decide;         
            decide=(Math.random()<0.5);
            if(decide==true) {  
            this.SerEmpleado=true;}
            else{
                this.SerEmpleado=false;
            }
        }
        else{
            System.out.println("el becario no cumplio sus 90 dias de prueba");;
        }
    }
    public String toString(){
        return super.toString()+"Fecha de Ingreso del Becario: \n"+this.FechaIngreso+"Fecha de Salida: \n"+this.FechaSalida+"Pudo Adquirir un puesto en la empresa? . . .\n "+this.SerEmpleado;
    }
    @Override
    public void SueldoPorAntiguedad(int AñoAntiguedad){
        if(this.SerEmpleado==true){
            SetSalario((GetSalario()*12)*0.00005+(this.AñoAntiguedad*10000));
        }
    }
    }