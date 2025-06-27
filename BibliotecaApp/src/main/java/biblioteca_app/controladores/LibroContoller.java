package biblioteca_app.controladores;

import biblioteca_app.datos.LibroDAO;
import biblioteca_app.datos.UsuarioDAO;
import biblioteca_app.dominio.Libro;
import biblioteca_app.presentacion.paneles.panelesUsuario.libroPanels.InfoPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibroContoller implements ActionListener {
    private LibroDAO libroDAO;
    private InfoPanel infoPanel;

    public LibroContoller(LibroDAO libroDAO, InfoPanel infoPanel){
        this.libroDAO = libroDAO;
        this.infoPanel = infoPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("buscar")){
        }
    }
}
