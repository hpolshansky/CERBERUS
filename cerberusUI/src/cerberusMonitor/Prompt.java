package cerberusMonitor;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Prompt {
    public Button sendBtn;
    public TextField input;
    public Text prompt;
    private String ipAddr;

    // constructor
    public Prompt(Text prompt) {
        this.prompt = prompt;

        try {
            this.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    sendBtn.setOnAction(e->{
        //get info from input
        //set variable for connection
//    });

    public void start() throws Exception {
        Stage newStage = new Stage();
        Parent notice = FXMLLoader.load(getClass().getResource("Prompt.fxml"));
        Scene stageScene = new Scene(notice, 300, 300);
//        stageScene.getStylesheets().add("cerberusMonitor/style.css");
        newStage.setScene(stageScene);
        newStage.show();
    }

}
