public class Main {
    public static void main(String[] args) {
        Cuadrado cuadrado = new Cuadrado("rojo",true,4);
        Rectangulo rectangulo = new Rectangulo(4,8,"verde",false);
        Circulo circulo = new Circulo("azul",false,3);

        System.out.println("el cuadrado resulta: "+cuadrado);
        System.out.println("el rectangulo resulta: "+rectangulo);
        System.out.println("el circulo resulta: "+circulo);

        double perimetro = 0;
        double area = 0;

        perimetro = cuadrado.getPerimetro();
        area = cuadrado.getArea();

        System.out.println();
        System.out.println("el area y perimetro del cuadrado son \n area: "+area+" , perimetro: "+perimetro);

        perimetro = rectangulo.getPerimetro();
        area = rectangulo.getArea();

        System.out.println();
        System.out.println("el area y perimetro del rectangulo son \n area: "+area+" , perimetro: "+perimetro);

        perimetro = circulo.getPerimetro();
        area = circulo.getArea();

        System.out.println();
        System.out.println("el area y perimetro del circulo son \n area: "+area+" , perimetro: "+perimetro);
    }
}