package cerberusMonitor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.logging.Level;

public class Main extends Application {
    static MonitorController monitorController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("monitor.fxml"));
        Parent root = (Parent) loader.load(getClass().getResource("monitor.fxml").openStream());
        primaryStage.setTitle("CERBERUS Monitor");
        monitorController = loader.getController();
        Scene scene = new Scene(root, 1000, 570);
        scene.getStylesheets().add("cerberusMonitor/style.css");

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


        VLCUtil.discover();
    }

    @Override
    public void stop() {
        monitorController.stopMedia();
    }


    public static void main(String[] args) {
        CERBERUSLogger.log(Level.INFO, CERBERUSLogger.class.getName()+" has started successfully.");
//        try {
//            // use server IP Address
//            IPAddress ip = new IPAddress();
//
//            Client c = new Client(InetAddress.getByName("192.168.1.66"), Integer.parseInt("2000"));
//            c.start(c);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        new Notifier("No server connected. Some functionality may be disabled.\n" +
//                "You are not connected to our server, Professor Stafford.", "No Connection", 2500);
        launch(args);
    }
}
