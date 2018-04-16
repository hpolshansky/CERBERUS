package cerberusMonitor;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.Player;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;

public class MonitorController {
    private Boolean open = false;
    private String themeColor;
    private Stage settingsStage = new Stage();
    private Stage teleopStage = new Stage();
    private Stage mapStage = new Stage();
    private Stage securityCameraStage = new Stage();
    private final WebView browser = new WebView();
    private final WebEngine webEngine = browser.getEngine();
    public Button teleop;
    public Button retrieveData;
    public Button settings;
    public ToggleButton toggleView;
    public ImageView frontView;
    public ImageView topView;
    public Text connection;
    public ImageView bg;
    public ImageView menu;

    @FXML
    public GridPane gridPane;

    private VideoPlayer player;

    // initialize func
    public void initialize() {
        System.out.println("Initializing");
//        new Notifier("No server connected. Some functionality may be disabled.\n" +
//                "You are not connected to our server, Professor Stafford.", "No Connection", 2500);
    }


    /**** Controller Functions ****/

    public void pressed() throws Exception {
//        new Notifier("This would retrieve data from CERBERUS if one was connected", "Retrieve Data", 0);
//        String mediaFile = "rtsp://192.168.1.10:554/user=admin&password=&channel=1&stream=0.sdp";


        // load the home page
//        webEngine.load("http://www.oracle.com/products/index.html");
            //add the web view to the scene
//            getChildren().add(browser);

        securityCameraStage.setTitle("Web View");
        Scene scene = new Scene(new Browser(),750,500, Color.web("#666970"));
        securityCameraStage.setScene(scene);
//        scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
        securityCameraStage.show();

//        securityCameraStage.setTitle("Web View");
//        Scene stageScene = new Scene(teleop, 300, 300);
//        stageScene.getStylesheets().add("cerberusMonitor/style.css");
//        securityCameraStage.setScene(stageScene);
//        securityCameraStage.show();

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

    @FXML
    public void playMedia() {
        player = new VideoPlayer("test");
        gridPane.getChildren().add(player);
        player.play("rtsp://192.168.1.10:554/user=admin&password=&channel=1&stream=0.sdp");
//        player.play("rtsp://192.168.1.10:554/user=admin&password=&channel=1&stream=0.sdp");
        player.setVolume(1);
    }

    @FXML
    public void stopMedia() {
        if (player != null) {
            player.release();
        }
    }

}
