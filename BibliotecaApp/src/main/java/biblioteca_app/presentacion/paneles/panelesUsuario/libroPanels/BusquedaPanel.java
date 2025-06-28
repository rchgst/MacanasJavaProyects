package biblioteca_app.presentacion.paneles.panelesUsuario.libroPanels;

import biblioteca_app.controladores.LibroContoller;

import javax.swing.*;
import java.awt.*;

public class BusquedaPanel extends JPanel {
    private JLabel titulo;
    private JLabel isbn;
    private JLabel vacio;
    private JTextField buscarTitulo;
    private JTextField buscarIsbn;
    private JButton buscar;
    private LibroContoller contol;

    public BusquedaPanel(LibroContoller control){
         titulo = new JLabel("buscar titulo");
         isbn = new JLabel("buscar isbn");
         buscarTitulo = new JTextField();
         buscarIsbn = new JTextField();
         buscar = new JButton("buscar");
         this.contol = control;

         setLayout(new GridLayout(1,5));
         add(titulo);
         add(buscarTitulo);
         add(isbn);
         add(buscarIsbn);
         add(buscar);
    }

    public JTextField getBuscarTitulo() {
        return buscarTitulo;
    }

    public JTextField getBuscarIsbn() {
        return buscarIsbn;
    }

    public JButton getBuscar() {
        return buscar;
    }
}
