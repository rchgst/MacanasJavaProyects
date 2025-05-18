public class Tablero {
    protected int[][] tablero;

    public Tablero(int[][]tablero){
        this.tablero = tablero;
    }
    public int recorreFila(int sumatoria){
        int p,n,b;
        for(int i=0;i<3;i++){
            p = n = b = 0;
            for(int j=0;j<3;j++){
                if(this.tablero[i][j]==-1)
                    n+=-1;
                else if(this.tablero[i][j]==1)
                    p+=1;
                else
                    b=1;
            }
            if(b == 1 && (p == sumatoria || n == -(sumatoria)))
                return i;
        }
        return -1;

    }
    public int recorreCol(int sumatoria){
        int p,n,b;
        for(int j=0;j<3;j++){
            p = n = b = 0;
            for(int i=0;i<3;i++){
                if(this.tablero[i][j]==-1)
                    n+=-1;
                else if(this.tablero[i][j]==1)
                    p+=1;
                else
                    b=1;
            }
            if(b == 1 && (p == sumatoria || n == -(sumatoria)))
                return j;
        }
        return -1;
    }
    public boolean recorreDiagP(int sumatoria){
        int a,b,c,band=0;
        boolean p,n;
        a = this.tablero[0][0];
        b = this.tablero[1][1];
        c = this.tablero[2][2];
        p = (a+b+c) == sumatoria;
        n = (a+b+c) == -(sumatoria);
        for(int i=0;i<3;i++){
            if(this.tablero[i][i] == 0)
                band = 1;
        }
        return band==1 && (p || n);
    }

    public boolean recorrerDiagS(int sumatoria){
        int a,b,c,band=0;
        boolean p,n;
        a = this.tablero[0][2];
        b = this.tablero[1][1];
        c = this.tablero[2][0];
        p = (a+b+c) == sumatoria;
        n = (a+b+c) == -(sumatoria);
        for(int i=0;i<3;i++){
            if(this.tablero[i][2-i] == 0)
                band = 1;
        }
        return band==1 && (p || n);
    }

    public boolean recorreFila(int sumatoria,int cond){
        int a;
        for(int i=0;i<3;i++){
            a = 0;
            for(int j=0;j<3;j++){
                if(this.tablero[i][j]==-1 && cond==-1)
                    a+=-1;
                else if(this.tablero[i][j]==1 && cond==1)
                    a+=1;
            }
            if(a == sumatoria || a == -(sumatoria))
                return true;
        }
        return false;

    }
    public boolean recorreCol(int sumatoria,int cond){
        int a;
        for(int j=0;j<3;j++){
            a = 0;
            for(int i=0;i<3;i++){
                if(this.tablero[i][j]==-1 && cond == -1)
                    a+=-1;
                else if(this.tablero[i][j]==1 && cond == 1)
                    a+=1;
            }
            if(a == sumatoria || a == -(sumatoria))
                return true;
        }
        return false;
    }
    public boolean recorreDiagP(int sumatoria,int cond){
        int a,b,c;
        boolean x=false;
        a = this.tablero[0][0];
        b = this.tablero[1][1];
        c = this.tablero[2][2];
        if(cond == -1)
            x = (a+b+c) == -(sumatoria);
        if(cond == 1)
            x = (a+b+c) == (sumatoria);
        return x;
    }

    public boolean recorrerDiagS(int sumatoria,int cond){
        int a,b,c;
        boolean x=false;
        a = this.tablero[0][2];
        b = this.tablero[1][1];
        c = this.tablero[2][0];
        if(cond == -1)
            x = (a+b+c) == -(sumatoria);
        if(cond == 1)
            x = (a+b+c) == (sumatoria);
        return x;
    }

    public boolean tableroCompleto(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(this.tablero[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

}
