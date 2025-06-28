package biblioteca_app.presentacion.paneles.panelesUsuario.libroPanels;

import javax.swing.*;
import java.awt.*;

public class ResultadoPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel contenedor;
    private InfoPanel infoPanel;

    public ResultadoPanel(){
        cardLayout = new CardLayout();
        contenedor = new JPanel(cardLayout);

        JPanel waitSearch = new JPanel();
        waitSearch.setLayout(new GridLayout(2,1));
        waitSearch.add(new JLabel("ingrese correctamente el nombre de un libro"));
        waitSearch.add(new JLabel("o el isbn del libro que desea obtener informacion"));

        infoPanel = new InfoPanel();

        contenedor.add(waitSearch,"esperaResult");
        contenedor.add(infoPanel,"infoLibro");

        add(contenedor);
        cardLayout.show(contenedor,"esperaResult");
    }

    public void mostrarEsperaResult(){
        cardLayout.show(contenedor,"esperaResult");
    }

    public void mostrarInfoLibro(){
        cardLayout.show(contenedor,"infoLibro");
    }

    public InfoPanel getInfoPanel() {
        return infoPanel;
    }
}
