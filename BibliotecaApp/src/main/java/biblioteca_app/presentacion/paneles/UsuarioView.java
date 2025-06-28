package biblioteca_app.presentacion.paneles;

import biblioteca_app.controladores.LibroContoller;
import biblioteca_app.datos.AutorDAO;
import biblioteca_app.datos.LibroDAO;
import biblioteca_app.datos.PrestamoDAO;
import biblioteca_app.presentacion.VentanaPrincipal;
import biblioteca_app.presentacion.paneles.panelesUsuario.*;

import javax.swing.*;

public class UsuarioView extends JPanel {
    private PanelLibro libros;
    private PanelPrestamos prestamos;
    private PanelAutores autores;
    private JTabbedPane pestañas;
    private LibroContoller contoller;
    private LibroDAO libroDAO;
    private AutorDAO autorDAO;
    private PrestamoDAO prestamoDAO;
    private VentanaPrincipal ventanaPrincipal;

    public UsuarioView(){
        libroDAO = new LibroDAO();
        autorDAO = new AutorDAO();
        prestamoDAO = new PrestamoDAO();

        libros = new PanelLibro(contoller);
        prestamos = new PanelPrestamos();
        autores = new PanelAutores();
        pestañas = new JTabbedPane();

        contoller = new LibroContoller(libroDAO,libros);
        libros.getBusquedaPanel().getBuscar().addActionListener(contoller);

        pestañas.add("libros",libros);
        pestañas.add("prestamos",prestamos);
        pestañas.add("autores",autores);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(pestañas);
        setVisible(true);
    }

}
