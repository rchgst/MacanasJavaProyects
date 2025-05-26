public class Matriz {
    private double[][] M;

    public Matriz(int filas, int columnas) {
        this.M = new double[filas][columnas];
    }

    public void setElem(int fila, int columna, double elemento) {
        if (existePos(fila, columna))
            this.M[fila][columna] = elemento;
        else
            System.out.println("La posición no es válida");
    }

    public void copy(Matriz m) {
        for (int i = 0; i < getCantFil(); i++) {
            for (int j = 0; j < getCantCol(); j++) {
                this.M[i][j] = m.getElem(i, j);
            }
        }
    }

    public int getCantFil() {
        return this.M.length;
    }

    public int getCantCol() {
        return this.M[0].length;
    }

    public boolean existePos(int fila, int col) {
        return (fila >= 0 && fila < getCantFil()) && (col >= 0 && col < getCantCol());
    }

    public double getElem(int f, int c) {
        if (existePos(f, c))
            return this.M[f][c];
        return -1;
    }

    public Matriz Clone() {
        Matriz m = new Matriz(this.getCantFil(), this.getCantCol());
        for (int i = 0; i < getCantFil(); i++)
            for (int j = 0; j < getCantCol(); j++)
                m.M[i][j] = this.M[i][j];
        return m;
    }

    public boolean equals(Matriz m) {
        if (this.getCantFil() != m.getCantFil() || this.getCantCol() != m.getCantCol())
            return false;

        for (int i = 0; i < getCantFil(); i++)
            for (int j = 0; j < getCantCol(); j++)
                if (this.M[i][j] != m.getElem(i, j))
                    return false;

        return true;
    }

    public boolean esCuadrada() {
        return getCantFil() == getCantCol();
    }

    public boolean esIdentidad() {
        if (!esCuadrada()) return false;

        for (int i = 0; i < getCantFil(); i++) {
            for (int j = 0; j < getCantCol(); j++) {
                if (i == j && M[i][j] != 1)
                    return false;
                else if (i != j && M[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public boolean esTriangSup() {
        for (int i = 1; i < getCantFil(); i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public boolean esTriangInf() {
        for (int i = 0; i < getCantFil(); i++) {
            for (int j = i + 1; j < getCantCol(); j++) {
                if (M[i][j] != 0)
                    return false;
            }
        }
        return true;
    }

    public boolean esRala() {
        int total = getCantFil() * getCantCol();
        int ceros = cantElem(0);
        return ceros > total / 2;
    }

    public int cantElem(double elem) {
        int c = 0;
        for (int i = 0; i < getCantFil(); i++) {
            for (int j = 0; j < getCantCol(); j++) {
                if (M[i][j] == elem)
                    c++;
            }
        }
        return c;
    }

    public boolean estaElem(double elem) {
        return cantElem(elem) > 0;
    }

    public Matriz suma(Matriz m) {
        Matriz res = new Matriz(getCantFil(), getCantCol());
        for (int i = 0; i < getCantFil(); i++) {
            for (int j = 0; j < getCantCol(); j++) {
                res.M[i][j] = this.M[i][j] + m.getElem(i, j);
            }
        }
        return res;
    }

    public Matriz producto(Matriz m) {
        if (this.getCantCol() != m.getCantFil()) {
            System.out.println("No se puede multiplicar: dimensiones incompatibles.");
            return null;
        }

        Matriz res = new Matriz(this.getCantFil(), m.getCantCol());
        for (int i = 0; i < res.getCantFil(); i++) {
            for (int j = 0; j < res.getCantCol(); j++) {
                for (int k = 0; k < this.getCantCol(); k++) {
                    res.M[i][j] += this.M[i][k] * m.M[k][j];
                }
            }
        }
        return res;
    }

    public Matriz producto1Escalar(double escalar) {
        Matriz res = this.Clone();
        for (int i = 0; i < res.getCantFil(); i++) {
            for (int j = 0; j < res.getCantCol(); j++) {
                res.M[i][j] *= escalar;
            }
        }
        return res;
    }

    public Matriz transpuesta() {
        Matriz res = new Matriz(getCantCol(), getCantFil());
        for (int i = 0; i < getCantFil(); i++) {
            for (int j = 0; j < getCantCol(); j++) {
                res.M[j][i] = M[i][j];
            }
        }
        return res;
    }

    public void mostrar() {
        for (int i = 0; i < getCantFil(); i++) {
            for (int j = 0; j < getCantCol(); j++) {
                System.out.print(M[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
