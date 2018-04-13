package cerberusMonitor;

import java.io.Serializable;

public class DataObject implements Serializable{
    private IPAddress ipAddr;

    // constructor
    public DataObject() {
        ipAddr = getIpAddr();
    }

    public IPAddress getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(IPAddress ipAddr) {
        this.ipAddr = ipAddr;
    }
}
