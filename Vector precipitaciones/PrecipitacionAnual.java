
public class PrecipitacionAnual{
    private double [] precipitacionAnual;
    private int indiceACargar;
public PrecipitacionAnual(){
    this.precipitacionAnual= new double[12];
    this.indiceACargar=0;
}
public void PrecipActual(double temperaturaActual){
    if(indiceACargar<this.precipitacionAnual.length){
        this.precipitacionAnual[indiceACargar]=temperaturaActual;
        this.indiceACargar++;}
}
public void SetPrecipMes(int mes, double temperatura){
    if(mes>=0 && mes<12){
        this.precipitacionAnual[mes]=temperatura;}
    else{
        System.out.println(("mes no valido"));
    }
}
private double sumameses(){
    int i;
    int suma=0;
    for(i=0;i<=this.indiceACargar;i++){
        suma+=this.precipitacionAnual[i];
    }
    return suma;

}
public double CalcularPromedioActual(){
 double suma=0;
    suma=sumameses();
 return suma/this.indiceACargar;
}
public double CalcularPromedioAnual(){
    double suma=0;
    for(int i=0;i<this.precipitacionAnual.length;i++){
        suma+=this.precipitacionAnual[i];
    }
    return suma/this.precipitacionAnual.length;
}
public double [] CalcularListaDesvios(){
    double [] listanuevos= new double[this.precipitacionAnual.length];
    for(int i=0;i<this.precipitacionAnual.length;i++){
        this.precipitacionAnual[i]=this.precipitacionAnual[i]-listanuevos[i]; }
        listanuevos=this.precipitacionAnual;
    return listanuevos;
}

}