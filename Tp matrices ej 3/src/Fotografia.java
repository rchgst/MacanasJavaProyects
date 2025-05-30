import java.util.Random;
public class Fotografia {
    private int[][] fotografia;
    private int F;
    private int C;
    private char[][] tablaEstrellas;

    public Fotografia(int M,int N){
        this.fotografia = new int[M][N];
        this.F=M;
        this.C=N;
    }
    public int getF(){
        return this.F;
    }
    public int getC(){
        return this.C;
    }

    public void generaFoto(){
        Random rnd = new Random();
        for (int i=0;i<this.F;i++){
            for(int j=0;j<this.C;j++)
                this.fotografia[i][j]=rnd.nextInt(256);
        }
    }
    public void generaTablaEst(){
        this.tablaEstrellas=new char[this.F][this.C];
        for(int i=0;i<this.F;i++) {
            this.tablaEstrellas[i][0] = ' ';
            this.tablaEstrellas[i][C-1]=' ';
        }
        for (int i=0;i<this.C;i++){
            this.tablaEstrellas[0][i]=' ';
            this.tablaEstrellas[F-1][i]=' ';
        }
        for(int i=1;i<this.F-1;i++){
            for (int j=1;j<this.C-1;j++){
                if((this.fotografia[i][j]+this.fotografia[i-1][j]+this.fotografia[i][j-1]+this.fotografia[i][j+1])>600)
                    this.tablaEstrellas[i][j]='*';
                else
                    this.tablaEstrellas[i][j]=' ';
            }
        }
    }
    public String toString(){
        String aux="";
        for(int f=0;f<this.F;f++){
            for (int c=0;c<this.C;c++){
                aux+="\t"+this.fotografia[f][c]+",";
            }
            aux+="\n";
        }
        return aux;
    }
    public String toStringEstrellas(){
        String aux="";
        for(int f=0;f<this.F;f++){
            for (int c=0;c<this.C;c++){
                aux+="\t"+this.tablaEstrellas[f][c]+",";
            }
            aux+="\n";
        }
        return aux;
    }
}
