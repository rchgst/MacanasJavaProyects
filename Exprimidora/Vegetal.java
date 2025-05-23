public class Vegetal {
    protected double peso;


    public Vegetal(){
    this.peso=0;
}
public Vegetal(double peso){
    this.peso=peso;
    
}
public double getPeso(){
    return this.peso;
}
public int Exprimir(){
    int jugo;
    jugo=(int)(getPeso()-(getPeso()*0.05));
    return jugo;
}
public void SetPeso(double peso){
    this.peso=peso;

}
public String toString(){
        return "Se exprimio:"+Exprimir();
    }
//---------------------------------------------------------------------------
public class Remolacha extends Vegetal{
    public String Nombre;
    public Remolacha(){
        super();
        this.Nombre="Remolacha";
    }
    public Remolacha(double peso){
        super(peso);
        this.Nombre="Remolacha";
    }
    @Override
    public int Exprimir(){
        int jugo;
        jugo=(int)((super.getPeso()-super.getPeso()*0.05 )*0.70);
        return jugo;
    }
    @Override
    public String toString(){
        return super.toString()+"De la "+this.Nombre;
    }
}
//---------------------------------------------------------------------------   
public class Zanahoria extends Vegetal{
    private String Nombre;
    public Zanahoria(){
        super();
        this.Nombre="Zanahoria";
    }
    public Zanahoria(double peso){
        super(peso);
    }
    @Override
    public int Exprimir(){
        int jugo;
        jugo=(int)((super.getPeso()-super.getPeso()*0.05)*0.40);
        return jugo;
    }
    @Override
    public String toString(){
        return super.toString()+"De la "+this.Nombre;
    }
}
//---------------------------------------------------------------------------
public class Tomate extends Vegetal{
    private String Nombre;
    public Tomate(){
        super();
        this.Nombre="Tomate";
    }
    public Tomate(double peso){
        super(peso);
        
    }
    @Override
    public int Exprimir(){
        int jugo;
        jugo=(int)((super.getPeso()-super.getPeso()*0.05)*0.80);
        return jugo;
    }
    @Override
    public String toString(){
        return super.toString()+"De la "+this.Nombre;
    }
}
//---------------------------------------------------------------------------
public class jengibre extends Vegetal{
    private String Nombre;
    public jengibre(){
        super();
        this.Nombre="Jengibre";
    }
    public jengibre(double peso){
        super(peso);
    
    }
    @Override
    public int Exprimir(){
        int jugo;
        jugo=(int)((super.getPeso()-super.getPeso()*0.05)*0.35);
        return jugo;
    }
    @Override
    public String toString(){
        return super.toString()+"De la "+this.Nombre;
    }
}
}