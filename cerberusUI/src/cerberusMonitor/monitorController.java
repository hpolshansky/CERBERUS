package cerberusMonitor;

import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import purejavahidapi.*;
import sun.security.ssl.Debug;

import java.io.IOException;

public class MonitorController {
    private Boolean open = false;
    public Button teleop;
    public Button retrieveData;
    public Button settings;

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

    public void menuClicked() {
        System.out.println("PRESSED");
        if(!open) {
            // open/make visible buttons
            btnVisible(true);
            open = true;
        }
        else if(open) {
            // close/make invisible buttons
            btnVisible(false);
            open = false;
        }

    }

    // set menu buttons to visible or not
    private void btnVisible(Boolean x) {
        teleop.setVisible(x);
        retrieveData.setVisible(x);
        settings.setVisible(x);
    }

    public void settingsMenu() throws Exception {
        System.out.println("COOKIE");
//        Stage newStage = new Stage();
//        Parent teleop = FXMLLoader.load(getClass().getResource("Settings.fxml"));
//        newStage.setTitle("Teleoperation Screen");
//        Scene stageScene = new Scene(teleop, 300, 300);
////        stageScene.getStylesheets().add("cerberusMonitor/style.css");
//        newStage.setScene(stageScene);
//        newStage.show();
    }

    public void expandMap() throws Exception {
        Stage newStage = new Stage();
        Parent map = FXMLLoader.load(getClass().getResource("map.fxml"));
        newStage.setTitle("Map");
        Scene stageScene = new Scene(map, 400, 400);
//        stageScene.getStylesheets().add("cerberusMonitor/style.css");
        newStage.setScene(stageScene);
        newStage.show();
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
