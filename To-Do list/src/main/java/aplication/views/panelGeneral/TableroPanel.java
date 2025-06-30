package aplication.views.panelGeneral;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TableroPanel extends JPanel {
    private List<TableroPanel> tareas;

    public TableroPanel(){
        tareas = new ArrayList<>();
    }

    public List<TableroPanel> getTareas() {
        return tareas;
    }
}
