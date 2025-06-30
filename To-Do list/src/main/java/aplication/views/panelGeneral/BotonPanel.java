package aplication.views.panelGeneral;

import javax.swing.*;

public class BotonPanel extends JPanel {
    private JButton agregar,finalizar,filtrar,eliminar;

    public BotonPanel(){
        agregar = new JButton("agregar tarea");
        finalizar = new JButton("finalizar tarea");
        filtrar = new JButton("buscar tarea");
        eliminar = new JButton("eliminar tarea");

        add(agregar);
        add(finalizar);
        add(filtrar);
        add(eliminar);
    }

}
