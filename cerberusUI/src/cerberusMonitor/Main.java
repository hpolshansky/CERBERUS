package cerberusMonitor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.InetAddress;

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
        try {
            // use server IP Address
//            IPAddress ip = new IPAddress();

            Client c = new Client(InetAddress.getByName("192.168.1.66"), Integer.parseInt("2000"));
            c.start(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
//        new Notifier("No server connected. Some functionality may be disabled.\n" +
//            "You are not connected to our server, Professor Stafford.", "No Connection", 2500);
    }
}
