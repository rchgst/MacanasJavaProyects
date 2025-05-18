import javax.print.attribute.standard.Finishings;

public class Algoritmo {
    private Tablero Matriz;

    public Algoritmo(Tablero Matriz){
        this.Matriz = Matriz;
    }

    public int busFaltanteFila(int fila/*le pasas la fila q suma 2 y devuelve */){
        for(int j = 0;j<3;j++){
            if(this.Matriz.tablero[fila][j] == 0)
                return (fila*10)+j;
        }
        return -1;
    }
    public int busFaltanteCol(int columna/*le pasas la col q suma 2*/){
        for(int i=0;i<3;i++){
            if(this.Matriz.tablero[i][columna] == 0)
                return (i*10)+columna;
        }
        return -1;
    }
    public int busFaltanteDiagP(/*le pasas la diag q suma 2*/){
        for(int i=0;i<3;i++){
            if(this.Matriz.tablero[i][i] == 0)
                return (i*10)+i;
        }
        return -1;
    }

    public int busFaltanteDiagS(){
        int j = 2;
        for (int i=0;i<3;i++){
            if(this.Matriz.tablero[i][j-i] == 0)
                return (i*10)+j;
        }
        return -1;
    }


}
