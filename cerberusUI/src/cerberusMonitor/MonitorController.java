package cerberusMonitor;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.logging.Level;

public class MonitorController {
    private Boolean open = false;
    private String themeColor;
    private VideoPlayer player;
    private Stage settingsStage = new Stage();
    private Stage teleopStage = new Stage();
    private Stage mapStage = new Stage();
//    private Stage securityCameraStage = new Stage();
//    private final WebView browser = new WebView();
//    private final WebEngine webEngine = browser.getEngine();
    public Button teleop;
    public Button retrieveData;
    public Button settings;
    public ToggleButton toggleView;
    public Text connection;
    public ImageView bg;
    public ImageView menu;
    public GridPane securityCamera;
    public GridPane zedCamera;
    SecurityCamera sc = new SecurityCamera();


    // initialize func
    public void initialize() {
        System.out.println("Initializing");
//        new Notifier("No server connected. Some functionality may be disabled.\n" +
//                "You are not connected to our server, Professor Stafford.", "No Connection", 2500);
    }


    /**** Controller Functions ****/

    public void retrieveData() throws Exception {
//        new Notifier("This would retrieve data from CERBERUS if one was connected", "Retrieve Data", 0);
//        securityCameraStage.setTitle("Web View");
//        Scene scene = new Scene(new Browser(),750,500, Color.web("#666970"));
//        securityCameraStage.setScene(scene);
//        securityCameraStage.show();

        securityCamera.setVisible(true);
        playSecurityMedia();
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
            CERBERUSLogger.log(Level.WARNING, "Server is connected");
        }
        else {
            connection.setText("DISCONNECTED");
            connection.setFill(Color.valueOf("#eaff00"));
            CERBERUSLogger.log(Level.WARNING, "Server is disconnected");
        }
    }

    // changes the camera views
    public void switchCamera() {
        if(securityCamera.isVisible()) {
            stopMedia();
            securityCamera.setVisible(false);
            playZedMedia();
            zedCamera.setVisible(true);
        }
        else if(!securityCamera.isVisible()) {
            stopMedia();
            zedCamera.setVisible(false);
            playSecurityMedia();
            securityCamera.setVisible(true);
        }
    }

    public void panLeft() {
        sc.moveCamera(1);
    }

    public void panRight() {
        sc.moveCamera(2);
    }

    public void panUp() {
        sc.moveCamera(3);
    }

    public void panDown() {
        sc.moveCamera(4);
    }

    public void zoomOutCamera() {
        sc.moveCamera(5);
    }

    public void zoomInCamera() {
        sc.moveCamera(6);
    }

    public void stopCamera() {
        sc.stopCamera();
    }

    public void playSecurityMedia() {
        player = new VideoPlayer("Security Camera (PTZ)");
        securityCamera.getChildren().add(player);
        player.play("rtsp://192.168.1.10:554/user=admin&password=&channel=1&stream=0.sdp");
        player.setVolume(1);
    }

    public void playZedMedia() {
        player = new VideoPlayer("Zed (Fixed)");
        securityCamera.getChildren().add(player);
        player.play("rtsp://192.168.1.10:554/user=admin&password=&channel=1&stream=0.sdp");
        player.setVolume(1);
    }

    public void stopMedia() {
        if (player != null) {
            player.release();
        }
    }

    // changes theme color
    public void setTheme(String color) {
        switch (color) {
            case "Red": // red
                Image bgRed = new Image("resources/bg2.png");
                Image menuRed = new Image("resources/ic_menu_white_36dp/ic_menu_white_36dp/web/ic_menu_white_36dp_2x_RED.png");
                bg.setImage(bgRed);
                menu.setImage(menuRed);
                themeColor = "Red";
                break;

            default: // blue
                Image bgBlue = new Image("resources/bg.jpg");
                Image menuBlue = new Image("resources/ic_menu_white_36dp/ic_menu_white_36dp/web/ic_menu_white_36dp_2x_BLUE.png");
                bg.setImage(bgBlue);
                menu.setImage(menuBlue);
                themeColor = "Blue";
                break;
        }
    }

    // gets current theme color
    public String getThemeColor() {
        if(themeColor == null) {
            themeColor = "Blue";
        }
        return themeColor;
    }

    /**** Pop up Stages ****/

    // opens the settings menu
    public void settingsMenu() throws Exception {
        Parent settingsMenu = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        settingsStage.setTitle("Settings");
        Scene stageScene = new Scene(settingsMenu, 300, 300);
        stageScene.getStylesheets().add("cerberusMonitor/style.css");
        settingsStage.setScene(stageScene);
        settingsStage.show();
    }

    public void expandMap() throws Exception {
        Parent map = FXMLLoader.load(getClass().getResource("map.fxml"));
        mapStage.setTitle("Map");
        Scene stageScene = new Scene(map, 600, 400);
//        stageScene.getStylesheets().add("cerberusMonitor/style.css");
        mapStage.setScene(stageScene);
        mapStage.show();
    }

    // Creates pop-up stage
    public void control() throws Exception {
        Parent teleop = FXMLLoader.load(getClass().getResource("teleopScreen.fxml"));
        teleopStage.setTitle("Teleoperation Screen");
        Scene stageScene = new Scene(teleop, 300, 300);
        stageScene.getStylesheets().add("cerberusMonitor/style.css");
        teleopStage.setScene(stageScene);
        teleopStage.show();
    }

    // closes pop up stages created by the monitor
    public void closePopUpStage(String stage) {
        if (stage.equals("Settings")) {
            settingsStage.close();
        } else if (stage.equals("Map")) {
            mapStage.close();
        } else if (stage.equals("Teleop")) {
            teleopStage.close();
        }
    }

}
