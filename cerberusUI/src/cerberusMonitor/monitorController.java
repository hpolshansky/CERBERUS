package cerberusMonitor;

import purejavahidapi.*;
import java.util.List;

public class monitorController {

    public void getDevices() {
        System.out.println("ZA");

        try {
            List<HidDeviceInfo> devList = PureJavaHidApi.enumerateDevices();
            for (HidDeviceInfo info : devList) {
                System.out.printf("VID = 0x%04X PID = 0x%04X Manufacturer = %s Product = %s Path = %s\n", //
                        info.getVendorId(), //
                        info.getProductId(), //
                        info.getManufacturerString(), //
                        info.getProductString(), //
                        info.getPath());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
