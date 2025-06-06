public class Rectangulo extends Figura{
    protected double base,altura;

    public Rectangulo(){}

    public Rectangulo(double base,double altura){
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo(double base,double altura,String color,boolean relleno){
        super(color,relleno);
        this.base = base;
        this.altura = altura;
    }

    public double getBase(){return base;}
    public void setBase(double base){this.base = base;}

    public double getAltura(){return altura;}
    public void setAltura(double altura){this.altura = altura;}

    @Override
    public double getArea() {
        return base*altura;
    }

    @Override
    public double getPerimetro() {
        return 2*base+2*altura;
    }

    public String toString(){
        return super.toString() + " base: "+base+" altura: "+altura;
    }
}
