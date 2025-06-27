package biblioteca_app.presentacion.paneles.panelesUsuario;

import biblioteca_app.controladores.LibroContoller;
import biblioteca_app.presentacion.paneles.panelesUsuario.libroPanels.*;

import javax.swing.*;

public class PanelLibro extends JPanel {
    private BusquedaPanel busquedaPanel;
    private ResultadoPanel resultadoPanel;
    private LibroContoller contoller;

    public PanelLibro(LibroContoller contoller){
        this.contoller = contoller;
        busquedaPanel = new BusquedaPanel(contoller);
        resultadoPanel = new ResultadoPanel();

        add(busquedaPanel);
        add(resultadoPanel);
        setVisible(true);
    }

}
