package cerberusMonitor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SettingsController implements java.io.Serializable {
    // TODO:
    // controls for cameras
    // display temp/status of system

    public ChoiceBox themeChoice;
    public String ipaddr;
//    public transient int i;
    // resolution???

    public String getIpaddr() {
        return ipaddr;
    }

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


    // sets the theme
    public void setTheme() {


    }


}
