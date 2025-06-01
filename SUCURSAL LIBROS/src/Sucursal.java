public class Sucursal {
    private String nombre;
    private TablaLibros librosEnSuc;
    private TablaPrestamos librosPrestados;
    private TablaAutores totalidadAutores;

    public Sucursal(String nombre){
        this.nombre=nombre;
        this.librosEnSuc=new TablaLibros(100);
        this.librosPrestados=new TablaPrestamos(100);
        this.totalidadAutores=new TablaAutores(100);
    }
    public void prestarLibro(Libro l,Sucursal s){
        Fecha fchDev= new Fecha();
        fchDev.fecha.plusMonths(1);
        Prestamo prestado = new Prestamo(l,s,fchDev);
        if(!s.librosEnSuc.estaLlena()){
            this.librosEnSuc.eliminarLibro(l);
            s.librosEnSuc.insertarLibro(l);
            this.librosPrestados.nuevoPrestamo(prestado);
        }
        else
            System.out.println("ERROR, LA SUCURSAR DE DESTINO NO CUENTA CON ESPACIO PARA RECIBIR EL LIBRO");

    }
    public TablaLibros librosNacionalidad(String nac){
        TablaLibros nueva = new TablaLibros(100);
        for(int i=0;i<this.librosEnSuc.cantidadLibros();i++){
            if(this.librosEnSuc.recuperarLibro(i).getAutor().getNacionalidad().equals(nac))
                nueva.insertarLibro(librosEnSuc.recuperarLibro(i));
        }
        if(nueva.hayLibros())
            return nueva;
        else{
            System.out.println("NO EXISTEN LIBROS CON AUTORES DE ESA NACIONALIDAD");
            return null;
        }
    }
    public double montoAseguradoPorAutor(String nombre){
        double ac =0;
        for (int i=0;i<this.librosEnSuc.cantidadLibros();i++){
            Libro actual=this.librosEnSuc.recuperarLibro(i);
            if(actual.getAutor().getNombre().equals(nombre))
                ac+=actual.montoAsegurado();
        }
        return ac;
    }
    public TablaLibros mayorMontoAsegurado(int n){
        double mayMonto=-1;
        int c=0,j=0;
        for(int i=0;i<this.librosEnSuc.cantidadLibros();i++){
            if(this.librosEnSuc.recuperarLibro(i).montoAsegurado()>mayMonto)
                mayMonto=this.librosEnSuc.recuperarLibro(i).montoAsegurado();
        }
        TablaLibros nueva = new TablaLibros(n);
            while (c<=n&&j<this.librosEnSuc.cantidadLibros()){
                if(this.librosEnSuc.recuperarLibro(j).montoAsegurado()==mayMonto){
                    nueva.insertarLibro(this.librosEnSuc.recuperarLibro(j));
                    c++;
                }
            j++;
            }
            //la lista nunca va a estar vacia, por lo menos un elem va a tener la may cant de mont asegurado
        if(nueva.cantidadLibros()<n){
            System.out.println("NO EXISTEN SUFICIENTES LIBROS CON "+mayMonto+" MONTO ASEGURADO, SE CREO UNA LISTA DE TAMAÑO" +nueva.cantidadLibros());
            return nueva;
        }
        System.out.println("LISTA DE "+n+" LIBROS CON EL MAYOR MONTO ASEGURADO CREADA");
        return nueva;
        }
    public TablaAutores autoresPopulares(int n){
    TablaAutores autoresPop = new TablaAutores(100);
        for(int i=0;i<this.totalidadAutores.cantidadAutores();i++){
            int j=0,c=0;
            boolean prestado= false;
            String buscado =this.totalidadAutores.recuperarAutor(i).getNombre();
            while (j<this.librosEnSuc.cantidadLibros()&&c<=n){
                if(buscado.equals(this.librosEnSuc.recuperarLibro(j).getAutor().getNombre()))
                    c++;
                j++;
            }
            if(c>n){//sobrepaso la cantidad minima->analizo si esta prestado algun libro del autor
                int k=0;
                boolean esta= false;
                while (k<this.librosPrestados.getCantidad()&&!esta){
                if(this.librosPrestados.getPrestamo(k).getLibro().getAutor().getNombre().equals(buscado))
                    esta = true;
                k++;
                if(esta)
                    autoresPop.insertarAutor(this.totalidadAutores.recuperarAutor(i));
                }
            }
        }
        if(!autoresPop.hayAutores()){
            System.out.println("NO HAY AUTORES POPULARES DE ACUERDO A LOS CRITERIOS DE BUSQUEDA");
            return null;
        }
        else
            return autoresPop;
    }
    public Autor autorLibroMayorPeso(){
        double may=-1;
        Autor retorno=null;
        for (int i=0;i<this.librosEnSuc.cantidadLibros();i++){
            Libro actual =this.librosEnSuc.recuperarLibro(i);
            if(actual instanceof Fisico){
                if(actual.getPeso()>may){
                    may=actual.getPeso();
                    retorno=actual.getAutor();
                }
            }
        }
        if(may==-1)
            System.out.println("NO EXISTEN AUTORES CON LIBROS FISICOS EN LA SUCURSAL");
        return retorno;
    }
}

