public class Fruta{
    private double peso;
public Fruta(){
    this.peso=0;
}
public Fruta(double peso){
    this.peso=peso;
}
public double getPeso(){
    return this.peso;
}
public int Exprimir(){
    int jugo;
    jugo=(int)(getPeso()-(getPeso()*0.10));
    return jugo;
}
public void SetPeso(double peso){
    this.peso=peso;
}
public String toString(){
        return "Se exprimio:"+Exprimir();
    }
//---------------------------------------------------------------------------
public class Manzana extends Fruta{
    private String Nombre;
    public Manzana(){
        super();
        this.Nombre="Manzana";
    }
    public Manzana(double peso){
        super(peso);
    }
    @Override
    public int Exprimir(){
        int jugo;
        jugo=(int)((super.getPeso()-super.getPeso()*0.10 )*0.75);
        return jugo;
    }
    @Override
    public String toString(){
        return super.toString()+"De la "+this.Nombre;
    }
}
//---------------------------------------------------------------------------   
public class Pera extends Fruta{
    private String Nombre;
    public Pera(){
        super();
        this.Nombre="Pera";
    }
    public Pera(double peso){
        super(peso);
    }
    @Override
    public int Exprimir(){
        int jugo;
        jugo=(int)((super.getPeso()-super.getPeso()*0.10)*0.85);
        return jugo;
    }
    @Override
    public String toString(){
        return "Se exprimio:"+Exprimir()+"De la "+this.Nombre;
    }
}
//---------------------------------------------------------------------------
public class Naranja extends Fruta{
    private String Nombre;
    public Naranja(){
        super();
        this.Nombre="Naranja";
    }
    public Naranja(double peso){
        super(peso);
    }
    @Override
    public int Exprimir(){
        int jugo;
        jugo=(int)((super.getPeso()-super.getPeso()*0.10)*0.90);
        return jugo;
    }
    @Override
    public String toString(){
        return super.toString()+"De la "+this.Nombre;
    }
}
}
