import java.util.ArrayList;

public abstract class ListaOrdenada {
    protected ArrayList<Object> lista;

    public ListaOrdenada() {
        this.lista = new ArrayList<>();
    }

    public int getTam() {
        return this.lista.size();
    }

    public boolean estaVacia() {
        return this.lista.isEmpty();
    }

    public abstract boolean menor(Object objA, Object objB);
    public abstract boolean mayor(Object objA, Object objB);
    public abstract boolean igual(Object objA, Object objB);

    public int posicionDe(Object obj) {
        return busquedaBinaria(obj);
    }

    public void insertar(Object obj) {
        int j = this.lista.size() - 1;
        while (j >= 0 && !this.mayor(obj, this.lista.get(j))) {
            j--;
        }
        this.lista.add(j + 1, obj);
    }

    public void eliminar(Object obj) {
        int pos = busquedaBinaria(obj);
        if (pos != -1)
            this.lista.remove(pos);
        else
            System.out.println("\nELEMENTO NO ENCONTRADO PARA ELIMINAR");
    }

    private int busquedaBinaria(Object obj) {
        int ini = 0, fin = this.lista.size() - 1;
        while (ini <= fin) {
            int mid = (ini + fin) / 2;
            if (this.igual(this.lista.get(mid), obj))
                return mid;
            if (this.menor(obj, this.lista.get(mid)))
                fin = mid - 1;
            else
                ini = mid + 1;
        }
        return -1;
    }

    public boolean esta(Object obj) {
        return busquedaBinaria(obj) != -1;
    }

    @Override
    public String toString() {
        String aux = "[ ";
        for (Object o : this.lista)
            aux += o + ",\t";
        aux += "]";
        return aux;
    }
}
