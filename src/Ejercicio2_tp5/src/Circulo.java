public class Circulo extends Figura{
    protected double radio;

    public Circulo(){}

    public Circulo(double radio){this.radio = radio;}

    public Circulo(String color,boolean relleno,double radio){
        super(color,relleno);
        this.radio = radio;
    }

    public double getRadio(){
        return radio;
    }

    public void setRadio(double radio){
        this.radio = radio;
    }

    @Override
    public double getArea() {
        return Math.PI*Math.pow(radio,2);
    }

    @Override
    public double getPerimetro(){
        return 2*Math.PI*radio;
    }

    public String toString(){
        return super.toString() +" radio: "+radio;
    }

}
