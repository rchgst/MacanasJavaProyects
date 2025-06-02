public class Sucursal {
    private String nombre;
    private TablaLibros librosEnSuc;
    private TablaPrestamo librosPrestados;
    private TablaAutores totalidadAutores;

    public Sucursal(String nombre,TablaLibros librosEnSuc,TablaPrestamo librosPrestados,TablaAutores totalidadAutores){
        this.nombre = nombre;
        this.librosEnSuc = librosEnSuc;
        this.librosPrestados = librosPrestados;
        this.totalidadAutores = totalidadAutores;
    }

    public void prestarLibro(Libro l,Sucursal s){
        Fecha fchDev = new Fecha();
        fchDev.nextMonth();

        s.librosEnSuc.insertarLibro(l);
        librosPrestados.nuevoPrestamo(new Prestamo(l,fchDev,s));
        librosEnSuc.eliminarLibro(l);
    }

    public TablaLibros librosNaciionalidad(String nac){
        TablaLibros nacionalidadLibros = new TablaLibros();
        for (int i=0;i< librosEnSuc.cantidadLibros();i++){
            if(librosEnSuc.getLibro(i).getAutor().igualNac(nac))
                nacionalidadLibros.insertarLibro(librosEnSuc.getLibro(i));
        }
        return nacionalidadLibros;
    }

    public double montoAseguradoPorAutor(String nombre){
        double acu=0;
        for (int i=0;i< librosEnSuc.cantidadLibros();i++){
            if(librosEnSuc.getLibro(i).igualAutor(nombre))
                acu+=librosEnSuc.getLibro(i).montoAsegurado();
        }
        return acu;
    }

    public TablaLibros mayorMontoAsegurado(int n){
        TablaLibros libros = new TablaLibros();
        int ind=0;
        for (int i=0;i<n;i++){
            double mayorMonto = 0;
            for (int j=0;j< librosEnSuc.cantidadLibros();j++){
                if(librosEnSuc.getLibro(i).montoAsegurado()>mayorMonto && libros.existeLibro(librosEnSuc.getLibro(i))==false){
                    ind = i;
                    mayorMonto = librosEnSuc.getLibro(i).montoAsegurado();
                }
            }
            libros.insertarLibro(librosEnSuc.getLibro(ind));
        }
        return libros;
    }

    public boolean prestoLibros(String nombre){
        for (int i=0;i<librosPrestados.getCantidad();i++){
            if(librosPrestados.getLibro(i).igualAutor(nombre))
                return true;
        }
        return false;
    }

    public int cuentaLibros(String nombre){
        int c=0;
        for (int i=0;i<librosEnSuc.cantidadLibros();i++){
            if(librosEnSuc.getLibro(i).igualAutor(nombre))
                c++;
        }
        return c;
    }

    public TablaAutores autoresPopulares(int n){
        TablaAutores populares = new TablaAutores();
        for(int i=0;i<totalidadAutores.cantidadAutores();i++){
            if(this.prestoLibros(totalidadAutores.getAutor(i).getNombre()) && this.cuentaLibros(totalidadAutores.getAutor(i).getNombre())>n)
                populares.insertarAutor(totalidadAutores.getAutor(i));
        }
        return populares;
    }

    public Autor autorLibroMayorPeso(){
        double mayorPeso = 0;
        int ind = 0;
        for (int i=0;i<librosEnSuc.cantidadLibros();i++){
            if(librosEnSuc.getLibro(i).getPeso()>mayorPeso){
                mayorPeso = librosEnSuc.getLibro(i).getPeso();
                ind = i;
            }
        }
        return librosEnSuc.getLibro(ind).getAutor();
    }

}
