package cerberusMonitor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import static cerberusMonitor.Main.monitorController;

public class SettingsController implements java.io.Serializable {

    public ChoiceBox<String> themeChoice;
    public TextField ipaddr;

    public void saveSettings() {
        // serializing the settings
//        try {
//            FileOutputStream fileOut =
//                    new FileOutputStream("/tmp/employee.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject();
//            out.close();
//            fileOut.close();
//            System.out.printf("Serialized data is saved in /tmp/employee.ser");
//        } catch (IOException i) {
//            i.printStackTrace();
//        }
    }
//    Text {
//        -fx-font: 20px System;
//    }

    @FXML
    private void initialize() {
        themeChoice.setItems(FXCollections.observableArrayList("Red", "Blue"));
        themeChoice.setValue(monitorController.getThemeColor());
    }

    // changes the theme
    private void changeTheme() {
        monitorController.setTheme(themeChoice.getValue());
    }

    public void applyChanges() {
        changeTheme();
//        saveSettings();
    }

    public void cancelChanges() {
        monitorController.closePopUpStage("Settings");
    }
}
