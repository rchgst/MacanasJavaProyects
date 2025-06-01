import java.util.ArrayList;

public class Libro {
    private int isbn;
    private ArrayList<Autor> autores;
    private Formato formato;
    private double precioNominal;

    public Libro(int isbn,ArrayList<Autor> autores,Formato formato,double precioNominal){
        this.isbn = isbn;
        this.autores = autores;
        this.formato = formato;
        this.precioNominal = precioNominal;
    }

    public int getIsbn() {
        return isbn;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public Formato getFormato() {
        return formato;
    }

    public double getPrecioNominal() {
        return precioNominal;
    }

    public double getPrecio() {
        if(this.formato.getTipo()== "tapa blanda" ){
            return this.precioNominal;
        }else if(this.formato.getTipo()== "tapa dura"){
            return (this.precioNominal*0.20)+this.precioNominal;
        } else if (this.formato.getTipo()== "mobi") {
            return this.precioNominal-(this.precioNominal*0.05);
        }else
            return this.precioNominal-(this.precioNominal*0.15);
    }
    public boolean equals(Libro otro){
        return this.isbn== otro.getIsbn();
    }
}
