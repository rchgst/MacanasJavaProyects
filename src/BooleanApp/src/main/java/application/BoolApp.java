
package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.TablaGenerator;

public class BoolApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        HBox loader = FXMLLoader.load(getClass().getResource("/MainView.fxml"));
        Scene scene = new Scene(loader);
        stage.setScene(scene);
        stage.show();
    }
}

