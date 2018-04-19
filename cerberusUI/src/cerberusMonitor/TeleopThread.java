package cerberusMonitor;

import purejavahidapi.HidDevice;
import purejavahidapi.HidDeviceInfo;
import purejavahidapi.PureJavaHidApi;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import static cerberusMonitor.Main.monitorController;

public class TeleopThread implements Runnable {
    volatile static boolean deviceOpen = false;
    volatile boolean finished;

    // TODO Stop this thread somehow.
    // thread to run
    public void run(){
        try {
            while (!finished) {
                HidDeviceInfo devInfo = null;
                if (!deviceOpen) {
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
                        CERBERUSLogger.log(Level.INFO, "Gamepad device found " + devInfo);
                        deviceOpen = true;
                        final HidDevice dev = PureJavaHidApi.openDevice(devInfo);

                        dev.setDeviceRemovalListener(source -> {
                            System.out.println("device removed");
                            deviceOpen = false;
                        });

                        // gets data from gamepad
                        dev.setInputReportListener((source, Id, data, len) -> {
//                            System.out.printf("onInputReport: id %d len %d data ", Id, len);
                            byte[] tx_data = new byte[4];
                            tx_data[0] = (byte)(data[2]+128);
                            tx_data[1] = (byte)(data[3]+128);
                            tx_data[2] = (byte)(data[6]+128);
                            tx_data[3] = (byte)(data[7]+128);
                            COBS encoder = new COBS();
                            byte[] msg = encoder.Encode(tx_data);
                            System.out.printf(Arrays.toString(tx_data));
                            Message.setMsg(msg);

//                            controlCameraPan(data[10], data[11]);
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

    private void controlCameraPan(byte i, byte j) {
        // pan & tilt
        switch (j) {
            case 0:
                monitorController.stopCamera();
                break;
            case 4:
                monitorController.panUp();
                break;
            case 8:
                monitorController.panRightUp();
                break;
            case 12:
                monitorController.panRight();
                break;
            case 16:
                monitorController.panRightDown();
                break;
            case 20:
                monitorController.panDown();
                break;
            case 24:
                monitorController.panLeftDown();
                break;
            case 28:
                monitorController.panLeft();
                break;
            case 32:
                monitorController.panLeftUp();
                break;
        }

        // zoom
        switch (i) {
            case 16:
                monitorController.zoomOutCamera();
                break;
            case 32:
                monitorController.zoomInCamera();
                break;
        }
    }


    public void start() {
        CERBERUSLogger.log(Level.INFO, "Teleoperation has started");
        finished = false;
        TeleopThread t = new TeleopThread();
        Thread thread = new Thread(t);
        thread.start();
    }
}