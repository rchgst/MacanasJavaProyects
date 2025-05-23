package ArregloVentas;
import java.util.Scanner;
public class VentaSemanal {
    private double[] ventas;

public VentaSemanal(){
    this.ventas= new double[1];
}
public VentaSemanal(int tamaño){
    this();
    if(tamaño>7){
        this.ventas= new double[7];}
    if(tamaño<1){
        this.ventas= new double[1];
    } 
    else{
        this.ventas= new double[tamaño];
    }
}
public VentaSemanal(double [] ventas){
    this(ventas.length);;
        this.ventas=ventas;

}

public void CargaVentas(){
    int i;
    Scanner Entrada= new Scanner(System.in);
    System.out.println("Ingrese -1 si no trabajo el día, en ese caso");
    for(i=0;i<this.ventas.length;i++){
        System.out.println("\n Ingrese la venta del día: "+i);
        this.ventas[i]= Entrada.nextDouble();
        Entrada.close();
    }
    
}

public double TotalVentas(){
    int i ;
    double TOT=0;
    for(i=0;i<this.ventas.length;i++){
        if(this.ventas[i]>=0){
        TOT+=this.ventas[i];
        }
    }
    return TOT;
}
public double PromedioVentas() {
    double TOT=0;
    int i, dias=0;
    for(i=0;i<this.ventas.length;i++){
        if(this.ventas[i]>=0){
            dias++;
        }
    }
    TOT=this.TotalVentas();
    return TOT/dias;
}
public String diaconMasVentas(){
    double mayor=0;
    int i;
    for(i=0;i<this.ventas.length;){
        if((this.ventas[i]>mayor)&(this.ventas[i]>0)){
            mayor=this.ventas[i];
        }
    }
     switch((int)mayor){
        case 0:
            return "Lunes";
        case 1:
            return "Martes";
        case 2:
            return "Miercoles";
        case 3:
            return "Jueves";
        case 4:
            return "Viernes";
        case 5:
            return "Sabado";
        default:
            return "No hay ventas en la semana.";
     }
}
}