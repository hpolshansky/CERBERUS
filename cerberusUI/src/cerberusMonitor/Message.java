package cerberusMonitor;

public class Message {
    private static byte[] msg;

    public Message() {
        msg = new byte[4];
    }

    public static synchronized byte[] getMsg() {
        return msg;
    }

    public static synchronized void setMsg(byte[] msg) {
        Message.msg = msg;
    }
//    private static String msg;
//
//    public Message() {
//        msg = "";
//    }
//
//    public static synchronized String getMsg() {
//        return msg;
//    }
//
//    public static synchronized void setMsg(String msg) {
//        Message.msg = msg;
//    }
}
