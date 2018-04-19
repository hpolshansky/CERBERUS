package cerberusMonitor;

import de.onvif.soap.OnvifDevice;
import de.onvif.soap.devices.PtzDevices;

import javax.xml.soap.SOAPException;
import java.net.ConnectException;
import java.util.Arrays;
import java.util.logging.Level;

public class SecurityCamera {
    private String pToken;
    private PtzDevices ptzDevices;
    private String hostIp = "192.168.1.10:8899";
    private String user = "admin";
    private String pass = "";

    // constructor
    public SecurityCamera(/*String hostIp, String user, String pass*/) throws Exception {
//        this.hostIp = hostIp;
//        this.user = user;
//        this.pass = pass;
        try {
            OnvifDevice nvt = new OnvifDevice(hostIp, user, pass);
            pToken = nvt.getDevices().getProfiles().get(0).getToken();
            ptzDevices = nvt.getPtz();
        } catch (ConnectException | SOAPException e) {
//            e.printStackTrace();
            CERBERUSLogger.log(Level.WARNING, Arrays.toString(e.getStackTrace()));
            System.out.println("HERE");
            throw new Exception();
//            monitorController.systemStatus.setText("System ERROR");
//            monitorController.systemStatus.setFill(Color.RED);
//            monitorController.disablePTZ();
        }
    }

    // moves camera
    // x: left = -1    right = 1
    // y: up = -1    down = 1
    public void moveCamera(int direction) {
        switch (direction) {
            case 1: // left
                ptzDevices.continuousMove(pToken, -1.0f, 0.0f, 0.0f);
                break;
            case 2: // right
                ptzDevices.continuousMove(pToken, 1.0f, 0.0f, 0.0f);
                break;
            case 3: // up
                ptzDevices.continuousMove(pToken, 0.0f, 1.0f, 0.0f);
                break;
            case 4: // down
                ptzDevices.continuousMove(pToken, 0.0f, -1.0f, 0.0f);
                break;
            case 5: // out
                ptzDevices.continuousMove(pToken, 0.0f, 0.0f, -1.0f);
                break;
            case 6: // in
                ptzDevices.continuousMove(pToken, 0.0f, 0.0f, 1.0f);
                break;
            case 7: // left & up
                ptzDevices.continuousMove(pToken, -1.0f, 1.0f, 0.0f);
                break;
            case 8: // left & down
                ptzDevices.continuousMove(pToken, -1.0f, -1.0f, 0.0f);
                break;
            case 9: // right & up
                ptzDevices.continuousMove(pToken, 1.0f, 1.0f, 0.0f);
                break;
            case 10: // right & down
                ptzDevices.continuousMove(pToken, 1.0f, -1.0f, 0.0f);
                break;
        }
    }

    // stop camera functions
    public void stopCamera() {
        ptzDevices.stopMove(pToken);
    }
}
