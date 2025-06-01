public class Autor {
    private String nombre;
    private String goodreads;

    public Autor(String nombre){
        this.nombre= nombre;
        this.goodreads="";
    }

    public String getNombre() {
        return nombre;
    }

    public String getGoodreads() {
        return goodreads;
    }

    public void setGoodreads(String goodreads) {
        this.goodreads = goodreads;
    }
}
