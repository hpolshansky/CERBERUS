package cerberusMonitor;

import com.googlecode.javacv.CanvasFrame;
import com.googlecode.javacv.OpenCVFrameGrabber;
import com.googlecode.javacv.cpp.opencv_core;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;

public class MonitorController {
    private Boolean open = false;
    public Button teleop;
    public Button retrieveData;
    public Button settings;
    public ToggleButton toggleView;
    public ImageView frontView;
    public ImageView topView;
    public Text connection;
    public ImageView bg;
    public ImageView menu;

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

    // Test func
    public void pressed() throws Exception {
        new Notifier("This would retrieve data from CERBERUS if one was connected", "Retrieve Data", 0);

//        OpenCVFrameGrabber frameGrabber = new OpenCVFrameGrabber("http://147.158.214.168:81/index.htm");
//        frameGrabber.setFormat("mjpeg");
//        frameGrabber.start();
//        opencv_core.IplImage iPimg = frameGrabber.grab();
//        CanvasFrame canvasFrame = new CanvasFrame("Camera");
//        canvasFrame.setCanvasSize(iPimg.width(), iPimg.height());
//
//        while (canvasFrame.isVisible() && (iPimg = frameGrabber.grab()) != null) {
//            canvasFrame.showImage(iPimg);
//        }
//        frameGrabber.stop();
//        canvasFrame.dispose();
//        System.exit(0);
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

    // sets the status of the server
    public void serverStatus(boolean s) {
        if (s) {
            connection.setText("CONNECTED");
            connection.setFill(Color.valueOf("#3bff00"));
        }
        else {
            connection.setText("DISCONNECTED");
            connection.setFill(Color.valueOf("#eaff00"));
        }
    }

    // changes theme color
    public void setTheme(int color) {
        switch (color) {
            case 1: // red
                Image bgRed = new Image("@../resources/bg2.png");
                Image menuRed = new Image("@../resources/ic_menu_white_36dp/ic_menu_white_36dp/web/ic_menu_white_36dp_2x_RED.png");
                bg.setImage(bgRed);
                menu.setImage(menuRed);
                break;

            default: // blue
                Image bgBlue = new Image("@../resources/bg.png");
                Image menuBlue = new Image("@../resources/ic_menu_white_36dp/ic_menu_white_36dp/web/ic_menu_white_36dp_2x_BLUE.png");
                bg.setImage(bgBlue);
                menu.setImage(menuBlue);
                System.out.println("SET");
                break;
        }
    }

    public void settingsMenu() throws Exception {
        Stage newStage = new Stage();
        Parent settingsMenu = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        newStage.setTitle("Settings");
        Scene stageScene = new Scene(settingsMenu, 300, 300);
        stageScene.getStylesheets().add("cerberusMonitor/style.css");
        newStage.setScene(stageScene);
        newStage.show();
    }

    public void expandMap() throws Exception {
        Stage newStage = new Stage();
        Parent map = FXMLLoader.load(getClass().getResource("map.fxml"));
        newStage.setTitle("Map");
        Scene stageScene = new Scene(map, 600, 400);
//        stageScene.getStylesheets().add("cerberusMonitor/style.css");
        newStage.setScene(stageScene);
        newStage.show();
    }

    public void switchCamera() {
        if(topView.isVisible()) {
            topView.setVisible(false);
            frontView.setVisible(true);
        }
        else if(!topView.isVisible()) {
            frontView.setVisible(false);
            topView.setVisible(true);
        }
        // else if camera(s) aren't working...
    }

    // Creates pop-up stage
    public void control() throws Exception {
        Stage newStage = new Stage();
        Parent teleop = FXMLLoader.load(getClass().getResource("teleopScreen.fxml"));
        newStage.setTitle("Teleoperation Screen");
        Scene stageScene = new Scene(teleop, 300, 300);
        stageScene.getStylesheets().add("cerberusMonitor/style.css");
        newStage.setScene(stageScene);
        newStage.show();
    }

}
