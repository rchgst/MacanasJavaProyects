
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private Label lblMensaje;

    @FXML
    void click(ActionEvent event) {
        System.out.println("hola mundo");
    }

}