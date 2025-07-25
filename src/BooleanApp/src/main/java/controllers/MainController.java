
package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainController {
    private ExpresionParser expresion;
    private boolean notContrllerNum;
    private LatexExpresion latexExpresion;

    public MainController(){
        expresion = new ExpresionParser();
        notContrllerNum = false;
        latexExpresion = new LatexExpresion();
    }

    @FXML
    private Button btnAND;

    @FXML
    private Button btnGenerar;

    @FXML
    private Button btnNOT;

    @FXML
    private Button btnOR;

    @FXML
    private Button btnVaciar;

    @FXML
    private Button btnVariableA;

    @FXML
    private Button btnVariableB;

    @FXML
    private Button btnVariableC;

    @FXML
    private Button btnVariableE;

    @FXML
    private Button btnVariableF;

    @FXML
    private Button btnVariabledD;

    @FXML
    private Button btnXOR;

    @FXML
    private Button btnParentesis1;

    @FXML
    private Button btnParentesis2;

    @FXML
    private ComboBox<Integer> comboBoxVariables;

    @FXML
    private Label lblFuncion;

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblResultadoFuncion;

    @FXML
    private TableView<FilaTabla> tabla;

    @FXML
    private ImageView imgResultado;

    private List<Button> botonesVariables;

    @FXML
    public void initialize() {
        comboBoxVariables.setItems(FXCollections.observableArrayList(1,2,3,4,5,6));

        // Inicializá la lista de botones
        botonesVariables = List.of(
                btnVariableA,
                btnVariableB,
                btnVariableC,
                btnVariabledD,
                btnVariableE,
                btnVariableF
        );

        for (Button boton : botonesVariables){
            boton.setVisible(false);
            boton.setManaged(false);
        }
    }

    private void mostrarBotonesVariables(int cantidad) {
        for (int i = 0; i < botonesVariables.size(); i++) {
            boolean visible = i < cantidad;
            botonesVariables.get(i).setDisable(i >= cantidad);
            botonesVariables.get(i).setVisible(visible);
            botonesVariables.get(i).setManaged(visible);
        }
    }

    @FXML
    void comboBoxEvent(ActionEvent event) {
        Integer cantidadVariables = comboBoxVariables.getValue();
        String variablesFuncion = "";
        if(cantidadVariables == null) return;

        //generar la tabla con todas las combinaciones
        TablaGenerator generador = new TablaGenerator(cantidadVariables);
        generador.generarTabla();
        char[][] datos = generador.getTabla();

        // Limpiar columnas anteriores
        tabla.getColumns().clear();

        // generar todas las columnas:
        for (int col=0;col<cantidadVariables;col++){
            int index = col;
            String nombreCol = String.valueOf((char) ('a'+col));   //calcula con el codigo ascci el caracter que va en dicha posicion
            variablesFuncion += nombreCol;
            TableColumn<FilaTabla, String > columna = new TableColumn<>(nombreCol);  //crea una nueva columna con el nombre que calculamos
            columna.setCellValueFactory(cellData -> cellData.getValue().getValor(nombreCol));
            tabla.getColumns().add(columna);
        }

        lblResultadoFuncion.setText("f ( "+variablesFuncion+" )");

        ObservableList<FilaTabla> filas = FXCollections.observableArrayList();
        for (int i=0;i<datos.length;i++){
            FilaTabla fila = new FilaTabla();
            for (int j=0;j<cantidadVariables;j++){
                String nombreCol = String.valueOf((char) ('a'+j));   //calcula con el codigo ascci el caracter que va en dicha posicion
                fila.setValor(nombreCol,datos[i][j]);
            }
            filas.add(fila);
        }
        tabla.setItems(filas);
        mostrarBotonesVariables(cantidadVariables);
    }

    private void actualizarImageView() {
        String expresionLatex = latexExpresion.getExpresion();
        if (!expresionLatex.isEmpty()) {
            imgResultado.setImage(LatexExpresion.renderToImage(expresionLatex, 20));
        } else {
            imgResultado.setImage(null); // opcional: limpia la imagen si está vacía
        }
    }

    @FXML
    void andClick(ActionEvent event) {
        expresion.andInExpresion();
        latexExpresion.andInExpresion();
        actualizarImageView();
    }

    @FXML
    void generarClick(ActionEvent event) {
        int cantidadVariables = comboBoxVariables.getValue();
        expresion.insertarANDImplicitos();
        expresion.mostrarExpresion();
        if (expresion.expresionValida(cantidadVariables)) {
            // Crear la expresión postfija
            ShutingYard shutingYard = new ShutingYard(expresion.getExpresion());
            List<String> postfijo = shutingYard.infijoToPostfijo();

            // Crear columna resultado
            TableColumn<FilaTabla, String> columna = new TableColumn<>();
            ImageView image = new ImageView(LatexExpresion.renderToImage(latexExpresion.getExpresion(),20));
            columna.setGraphic(image);
            columna.setCellValueFactory(cellData -> cellData.getValue().getValor("resultado"));
            tabla.getColumns().add(columna);

            // Evaluar cada fila
            for (FilaTabla fila : tabla.getItems()) {
                Map<Character, Boolean> valores = new HashMap<>();

                // Recorrer todas las variables desde 'a' hasta la cantidad seleccionada
                for (int i = 0; i < cantidadVariables; i++) {
                    char variable = (char) ('a' + i);
                    // Obtener el valor como "0" o "1"
                    String valorStr = fila.getTodos().get(String.valueOf(variable)).get();
                    boolean valorBool = valorStr.equals("1");
                    valores.put(variable, valorBool);
                }
                System.out.println();
                // Evaluar la expresión para esa fila
                boolean resultado = shutingYard.evaluarPostfija(postfijo, valores);
                // Guardar el resultado en la fila (como "0" o "1")
                fila.setValor("resultado", resultado ? '1' : '0');
            }
        }
    }

    public void alternarNotController(){
        if(notContrllerNum)
            notContrllerNum=false;
        else
            notContrllerNum=true;
    }

    @FXML
    void notClick(ActionEvent event) {
        if(!notContrllerNum || latexExpresion.getExpresion().isEmpty()){
            expresion.notInExpresion();
            latexExpresion.notInExpresion();
        }
        else
            latexExpresion.closeExpresion();
        alternarNotController();
        actualizarImageView();
    }

    @FXML
    void orClick(ActionEvent event) {
        expresion.orInExpresion();
        latexExpresion.orInExpresion();
        actualizarImageView();
    }

    @FXML
    void vaciarClick(ActionEvent event) {
        expresion.setExpresion("");
        latexExpresion.setExpresion("");
        expresion.mostrarExpresion();
        latexExpresion.mostrarLatexExpresion();
        actualizarImageView();
    }

    @FXML
    void xorClick(ActionEvent event) {
        expresion.xorInExpresion();
        latexExpresion.xorInExpresion();
        actualizarImageView();
    }

    @FXML
    void parentesis1Click(ActionEvent event) {
        expresion.parentesisIzqInExpresion();
        latexExpresion.parentesisIzqInExpresion();
        actualizarImageView();
    }

    @FXML
    void parentesis2Click(ActionEvent event) {
        expresion.parentesisDerInExpresion();
        latexExpresion.parentesisDerInExpresion();
        actualizarImageView();
    }

    @FXML
    void clickVariable(ActionEvent event) {
        Button boton = (Button) event.getSource();
        expresion.variableInExpresion(boton.getText().charAt(0));
        latexExpresion.variableInExpresion(boton.getText());
        actualizarImageView();
    }

}
