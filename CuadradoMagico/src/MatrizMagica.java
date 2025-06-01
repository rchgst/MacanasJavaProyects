public class MatrizMagica extends Matriz {
    public MatrizMagica(int n) {
        super(n);
    }

    public boolean esCuadradoMagico() {
        int ac, c, f = 0, total = 0;
        boolean cumple = true;
        for (int i = 0; i < this.getFilas(); i++)
            total += getValor(i, i);
        //analisis de filas
        while (cumple && f < this.getFilas()) {
            ac = 0;
            c = 0;
            while (cumple && c < this.getColumnas()) {
                ac += this.getValor(f, c);
                c++;
            }
            if (ac != total)
                cumple = false;
            f++;
        }
        //analisis de columnas
        c = 0;
        while (cumple && c < this.getColumnas()) {
            f = 0;
            ac = 0;
            while (cumple && f < this.getFilas()) {
                ac += getValor(f, c);
                f++;
            }
            if (ac != total)
                cumple = false;
            c++;
        }
        //analisis diag secundaria
        if(cumple) {
            ac = 0;
            for (int i = 0; i < this.getFilas(); i++)
                ac += getValor(i, this.getFilas() - 1 - i);
            if (ac != total)
                cumple = false;
        }
        return cumple;
    }
    public void mostrar(){
       String aux ="";
        for (int i=0;i<this.getFilas();i++){
            for (int j=0;j<this.getColumnas();j++)
                aux+=getValor(i,j)+"\t";
            aux+="\n";
        }
        System.out.println(aux);
    }
}
