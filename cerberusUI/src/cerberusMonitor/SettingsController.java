package cerberusMonitor;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;

import static cerberusMonitor.Main.monitorController;

public class SettingsController implements java.io.Serializable {

    public ChoiceBox<String> themeChoice;
    public String ipaddr;
    private String themeColor;
//    public transient int i;

    public void setIpaddr(String ipaddr) {
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

    @FXML
    private void initialize() {
        themeChoice.setItems(FXCollections.observableArrayList("Red", "Blue"));
        themeChoice.setValue(getThemeColor());
    }

    // changes the theme
    private void changeTheme() {
        themeChoice.getSelectionModel().selectedIndexProperty()
                .addListener((ov, value, new_value) -> {
                    System.out.println("COLOR: " + new_value.intValue());
                    monitorController.setTheme(new_value.intValue());
                    switch (new_value.intValue()) {
                        case 1: // red
                            setThemeColor("Red");
                            break;

                        default: // blue
                            setThemeColor("Blue");
                            break;
                    }
                });
    }

    public void applyChanges() {
//        setIpaddr("");
        changeTheme();
    }

    public String getIpaddr() {
        return ipaddr;
    }

    private String getThemeColor() {
        return themeColor;
    }

    private void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }
}
