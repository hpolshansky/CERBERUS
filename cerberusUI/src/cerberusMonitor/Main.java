package cerberusMonitor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import purejavahidapi.*;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("monitor.fxml"));
        primaryStage.setTitle("CERBERUS Monitor");
//        primaryStage.setFullScreen(true);
        Scene scene = new Scene(root, 1000, 570);
        scene.getStylesheets().add("cerberusMonitor/style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
