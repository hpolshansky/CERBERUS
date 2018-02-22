package cerberusMonitor;

import purejavahidapi.*;
import java.util.List;

public class TeleopThread implements Runnable {
    volatile static boolean deviceOpen = false;
    volatile boolean finished;
    byte[] msg = new byte[4];

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
//                            byte b0 = (byte) ((1<<7) | (data[2]>>1));
//                            byte b1 = (byte) (((data[2]&0x01)<<6) | (0x3F & (data[3]>>2)));
//                            byte b2 = (byte) ((data[6]>>1));
//                            byte b3 = (byte) (((data[6]&0x01)<<6) | (0x3F & (data[7]>>2)));
//
//                            byte b0 = data[2];
//                            byte b1 = data[3];
//                            byte b2 = data[6];
//                            byte b3 = data[7];
                            byte b0 = (byte) 0xFB;
                            byte b1 = (byte) 0x92;
                            byte b2 = 0x3A;
                            byte b3 = 0x55;
                            msg[0]  = b0;
                            msg[1]  = b1;
                            msg[2]  = b2;
                            msg[3]  = b3;
                            System.out.printf("%02X ", b0);
                            System.out.printf("%02X ", b1);
                            System.out.printf("%02X ", b2);
                            System.out.printf("%02X ", b3);

//                            for(int i = 2; i < 4; i++) {
//                                msg = msg + String.format("%02X", data[i]);
//                            }
//                            for(int i = 6; i < 8; i++) {
//                                msg = msg + String.format("%02X", data[i]);
//                            }

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