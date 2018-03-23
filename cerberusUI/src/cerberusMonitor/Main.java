package cerberusMonitor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import purejavahidapi.HidDeviceInfo;
import purejavahidapi.PureJavaHidApi;

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
//        try {
//            // use server IP Address
////            IPAddress ip = new IPAddress();
//
//            Client c = new Client(InetAddress.getByName("192.168.1.1"), Integer.parseInt("2000"));
//            c.start(c);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            List<HidDeviceInfo> devList = PureJavaHidApi.enumerateDevices();
//            for (HidDeviceInfo info : devList) {
//                System.out.printf("VID = 0x%04X PID = 0x%04X Manufacturer = %s Product = %s Path = %s\n", //
//                        info.getVendorId(), //
//                        info.getProductId(), //
//                        info.getManufacturerString(), //
//                        info.getProductString(), //
//                        info.getPath());
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        launch(args);
//        new Notifier("No server connected. Some functionality may be disabled.\n" +
//            "You are not connected to our server, Professor Stafford.", "No Connection", 2500);
    }
}
