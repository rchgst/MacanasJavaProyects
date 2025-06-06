public class Cuadrado extends Rectangulo{

    public Cuadrado(){}

    public Cuadrado(double lado){
        this.base = lado;
        this.altura = lado;
    }

    public Cuadrado(String color,boolean relleno,double lado){
        super(lado,lado,color,relleno);
    }

    public double getLado(){return this.base;}
    public void setLado(double lado){
        this.base = lado;
        this.altura = lado;
    }

    public void setAltura(double altura){this.altura = altura;}
    public void setBase(double base){this.base = base;}
}
