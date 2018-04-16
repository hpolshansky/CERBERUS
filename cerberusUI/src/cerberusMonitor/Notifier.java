package cerberusMonitor;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Notifier {
    public Label noteArea;
    private String msg;
    private String title;

    Notifier(String msg, String title, long time) {
        this.msg = msg;
        this.title = title;
        try {
            notifyUser(time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void notifyUser(long time) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Notifier.fxml"));
        loader.setControllerFactory(type -> {
            if (type == Notifier.class) {
                return this ;
            } else {
                try {
                    return type.newInstance();
                } catch (RuntimeException e) {
                    throw e ;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle(getTitle());
        stage.setScene(new Scene(root));
        noteArea.setText(getMsg());
        stage.show();
        if(time != 0) {
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(time),
                    ae -> stage.close()));
            timeline.play();
        }
    }

    private String getMsg() {
        return msg;
    }

    private String getTitle() {
        return title;
    }
}
