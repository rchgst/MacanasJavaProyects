package aplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/LoginView.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }
}