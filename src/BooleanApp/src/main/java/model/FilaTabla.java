
package model;

import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;
import java.util.Map;

public class FilaTabla {
    private Map<String, SimpleStringProperty> valores;

    public FilaTabla(){
        valores = new HashMap<>();
    }

    public void setValor(String variable, char valor){
        valores.put(variable,new SimpleStringProperty(String.valueOf(valor)));
    }

    public SimpleStringProperty getValor(String variable){
        return valores.get(variable);
    }

    public Map<String, SimpleStringProperty> getTodos(){
        return valores;
    }
}
