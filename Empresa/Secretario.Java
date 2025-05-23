public class Secretario extends Empleado{
    public String Despacho;
    public String Fax;

public Secretario(){
    super();
    this.Despacho="";
    this.Fax="";
}
public Secretario(String nombre,String Documento,String Direccion,int AñoAntiguedad, String Telefono, double, Salario, String Despacho, String Fax){
    super(nombre, Documento, Direccion, AñoAntiguedad, Telefono, Salario);
    this.Despacho=Despacho;
    this.Fax=Fax;
}
public String to String(){
    return super.toString()+"Despacho: "+this.Despacho+"Fax: "+this.Fax;
}
@Override
   public void SueldoPorAntiguedad(int AñoAntiguedad){
        if(this.SerEmpleado==true){
        SetSalario((GetSalario()*12)*0.0001+(this.AñoAntiguedad*10000));
        }
    }

}