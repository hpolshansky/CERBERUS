package cerberusMonitor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IPAddress implements java.io.Serializable {
    public String ipaddr;

    public IPAddress() {
        ipaddr = "";
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }
}
