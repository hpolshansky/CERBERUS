package cerberusMonitor;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class MapController {
    public Pane rosMap;
    public Text instructions;
    public Button submitMap;
    public  Button resetMap;
    private int flag = 0;

    public void checkSteps() {
        // get mouse click xy position
//        rosMap.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override public void handle(MouseEvent event) {
////                System.out.println("x: " + event.getX() + ", y: " + event.getY());
//                x_loc = event.getX();
//                y_loc = event.getY();
//            }
//        });
        double x_loc = 550;
        double y_loc = 200;
        if(flag == 0) setPosition(x_loc, y_loc);
        else if(flag == 1) setDirection(x_loc, y_loc);
    }

    // resets instructions and map values
    public void resetMap() {
        // remove red dot
        // remove path
        // remove arrow if chosen
        // reset instructions
        instructions.setText("Click in the map to where CERBERUS should move to.");
        flag = 0; // reset flag
        submitMap.setDisable(true); // disable submit button
        resetMap.setDisable(true); // disable reset button
    }

    // sends instructions to CERBERUS and notifies user
    public void checkSent() {
        // send instructions to CERBERUS
        // have waiting symbol to show user

        // pop up message confirming instructions sent to robot
        new Notifier("Instructions successfully sent to CERBERUS\n...Is what this " +
                "would say if a CERBERUS was connected", "Message Sent", 5000);
    }

    // sets robot position
    private void setPosition(double centerX, double centerY){
        // create red dot object on screen where mouse clicked
//        Circle circle = new Circle(centerX, centerY, 11.0f);
//        circle.setFill(Color.RED);

        flag = 1;
        resetMap.setDisable(false);
        instructions.setText("Click in the direction CERBERUS should point to.");
    }

    // sets direction of robot
    private void setDirection(double x, double y){
        // create green arrow to show direction
        submitMap.setDisable(false); // enable submit button
        // have user review selections
        flag = 2;
        instructions.setText("Please review and submit the location and direction CERBERUS will be moving to.");
    }
}
