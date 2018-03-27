package cerberusMonitor;

import purejavahidapi.*;

import java.util.Arrays;
import java.util.List;

public class TeleopThread implements Runnable {
    volatile static boolean deviceOpen = false;
    volatile boolean finished;

    public void run(){
        System.out.println("thread is running...");
        try {
            while (!finished) {
                HidDeviceInfo devInfo = null;
                if (!deviceOpen) {
                    System.out.println("scanning");
                    List<HidDeviceInfo> devList = PureJavaHidApi.enumerateDevices();
                    for (HidDeviceInfo info : devList) {
                        // finds gamepad device
                        if (info.getVendorId() == (short) 0x1BAD && info.getProductId() == (short) 0xFA01) {
                            devInfo = info;
                            break;
                        }
                    }
                    if (devInfo == null) {
                        System.out.println("device not found");
                        Thread.sleep(1000);
                    } else {
                        System.out.println("device found " + devInfo);
                        deviceOpen = true;
                        final HidDevice dev = PureJavaHidApi.openDevice(devInfo);

                        dev.setDeviceRemovalListener(source -> {
                            System.out.println("device removed");
                            deviceOpen = false;

                        });
                        dev.setInputReportListener((source, Id, data, len) -> {
                            System.out.printf("onInputReport: id %d len %d data ", Id, len);
                            byte[] tx_data = new byte[4];
                            tx_data[0] = (byte)(data[2]+128);
                            tx_data[1] = (byte)(data[3]+128);
                            tx_data[2] = (byte)(data[6]+128);
                            tx_data[3] = (byte)(data[7]+128);
                            COBS encoder = new COBS();
                            byte[] msg = encoder.Encode(tx_data);
                            System.out.printf(Arrays.toString(tx_data));

                            Message.setMsg(msg);
                            System.out.println();
                        });
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public byte genByte(int val) {
        return ((byte)val);
    }
    public void stop() {
        finished = true;
    }

    public void start() {
        finished = false;
        TeleopThread t = new TeleopThread();
        Thread thread = new Thread(t);
        thread.start();
    }


}