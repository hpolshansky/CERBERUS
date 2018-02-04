package cerberusMonitor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import purejavahidapi.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Scanner;

public class monitorController {

//    Initial Input: (** indicate selection effected)
//    onInputReport: id 0 len 14 data 00 80 FF 7F 00 80 FF 7F 00 80 00 80 01 F8
//    00 00=l, FF FF=r; left roller pad
//    onInputReport: id 0 len 14 data *00 80* FF 7F 00 80 FF 7F 00 80 00 80 01 F8
//    00 00=u, FF FF=d; left roller pad
//    onInputReport: id 0 len 14 data 00 80 *FF 7F* 00 80 FF 7F 00 80 00 80 01 F8
//    00 00=l, FF FF=r; right roller pad
//    onInputReport: id 0 len 14 data 00 80 FF 7F *00 80* FF 7F 00 80 00 80 01 F8
//    00 00=u, FF FF=d; right roller pad
//    onInputReport: id 0 len 14 data 00 80 FF 7F 00 80 *FF 7F* 00 80 00 80 01 F8
//    80 FF=LT, 80 00=RT
//    onInputReport: id 0 len 14 data 00 80 FF 7F 00 80 FF 7F *00 80* 00 80 01 F8
//    01=A, 02=B, 04=X, 08=Y
//    onInputReport: id 0 len 14 data 00 80 FF 7F 00 80 FF 7F 00 80 *00* 80 01 F8
//    10=LB, 20=RB
//    onInputReport: id 0 len 14 data 00 80 FF 7F 00 80 FF 7F 00 80 *00* 80 01 F8
//    40=back, 80=start
//    onInputReport: id 0 len 14 data 00 80 FF 7F 00 80 FF 7F 00 80 *00* 80 01 F8
//    9C=l, 8C=r, 84=u, 94=d; small arrow pad
//    onInputReport: id 0 len 14 data 00 80 FF 7F 00 80 FF 7F 00 80 00 *80* 01 F8

    /*
     * FXML CODE
     */

    // Test func
    public void pressed() {
        System.out.println("PIZZA");
    }

    // Creates pop-up stage
    public void control() throws Exception {
        Stage newStage = new Stage();
        Parent teleop = FXMLLoader.load(getClass().getResource("teleopScreen.fxml"));
        newStage.setTitle("Teleoperation Screen");
        Scene stageScene = new Scene(teleop, 300, 300);
//        stageScene.getStylesheets().add("cerberusMonitor/style.css");
        newStage.setScene(stageScene);
        newStage.show();
    }

}
