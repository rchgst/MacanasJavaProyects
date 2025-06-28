package biblioteca_app.controladores;

import biblioteca_app.datos.LibroDAO;
import biblioteca_app.datos.UsuarioDAO;
import biblioteca_app.dominio.Libro;
import biblioteca_app.presentacion.paneles.panelesUsuario.PanelLibro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibroContoller implements ActionListener {
    private LibroDAO libroDAO;
    private PanelLibro panelLibro;

    public LibroContoller(LibroDAO libroDAO, PanelLibro panelLibro){
        this.libroDAO = libroDAO;
        this.panelLibro = panelLibro;
    }

    public Libro filtraBusqueda(){
        Libro libro = null;
        String titulo = panelLibro.getBusquedaPanel().getBuscarTitulo().getText();
        String isbn = panelLibro.getBusquedaPanel().getBuscarIsbn().getText();

        if(titulo.length()>0 && isbn.length()>0){
            libro = libroDAO.buscar(titulo,isbn);
            System.out.println("titulo != vacio && isbn != vacio");
        }
        else if(titulo.length()>0) {
            libro = libroDAO.buscarPorTitulo(titulo);
            System.out.println("titulo != vacio");
        }
        else if(isbn.length()>0) {
            libro = libroDAO.buscarPorIsbn(isbn);
            System.out.println("isbn != vacio");
        }
        return libro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("buscar")){
            Libro libro = this.filtraBusqueda();
            if(libro != null) {
                panelLibro.getResultadoPanel().mostrarInfoLibro();
                panelLibro.getResultadoPanel().getInfoPanel().generarDatos(libro);
            }
            else{
                panelLibro.getResultadoPanel().mostrarEsperaResult();
                System.out.println("no se encontro el libro");
            }
        }
    }
}
