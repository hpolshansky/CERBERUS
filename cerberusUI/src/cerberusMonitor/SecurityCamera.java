package cerberusMonitor;

import de.onvif.soap.OnvifDevice;
import de.onvif.soap.devices.PtzDevices;

import javax.xml.soap.SOAPException;
import java.net.ConnectException;

public class SecurityCamera {
    private OnvifDevice nvt;
    private String pToken;
    private PtzDevices ptzDevices;
    private String hostIp = "192.168.1.10:8899";
    private String user = "admin";
    private String pass = "";

    // constructor
    public SecurityCamera(/*String hostIp, String user, String pass*/) {
//        this.hostIp = hostIp;
//        this.user = user;
//        this.pass = pass;
        try {
            nvt = new OnvifDevice(hostIp, user, pass);
            pToken = nvt.getDevices().getProfiles().get(0).getToken();
            ptzDevices = nvt.getPtz();
        } catch (ConnectException | SOAPException e) {
            e.printStackTrace();
        }
    }

    // moves camera
    // x: left = -1    right = 1
    // y: up = -1    down = 1
    public void moveCamera(int direction) {
        switch (direction) {
            case 1:
                ptzDevices.continuousMove(pToken, -1.0f, 0.0f, 0.0f);
                break;
            case 2:
                ptzDevices.continuousMove(pToken, 1.0f, 0.0f, 0.0f);
                break;
            case 3:
                ptzDevices.continuousMove(pToken, 0.0f, 1.0f, 0.0f);
                break;
            case 4:
                ptzDevices.continuousMove(pToken, 0.0f, -1.0f, 0.0f);
                break;
            case 5:
                ptzDevices.continuousMove(pToken, 0.0f, 0.0f, -1.0f);
                break;
            case 6:
                ptzDevices.continuousMove(pToken, 0.0f, 0.0f, 1.0f);
                break;
        }
    }

    // stop camera functions
    public void stopCamera() {
        ptzDevices.stopMove(pToken);
    }
}
