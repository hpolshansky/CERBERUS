package cerberusMonitor;

import purejavahidapi.*;

import java.util.List;

public class teleopThread implements Runnable {
    volatile static boolean deviceOpen = false;
    Message msg = new Message();

    public void run(){
        System.out.println("thread is running...");
        try {
            while (true) {
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
//                            for (int i = 0; i < len; i++) {
////                                System.out.printf("%02X ", data[i]);
//                            }
                            msg.setMsg("COOKIE????");
//                            msg.setMsg(String.format("%02X", data[3]));
//                            System.out.println(msg.getMsg());
//                            System.out.println();
                        });
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void start() {
        teleopThread t = new teleopThread();
        Thread thread = new Thread(t);
        thread.start();
    }


}