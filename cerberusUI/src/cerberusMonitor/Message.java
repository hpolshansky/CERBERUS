package cerberusMonitor;

public class Message {
    private static byte[] msg;

    public Message() {
        msg = new byte[6];
    }

    public static synchronized byte[] getMsg() {
        return msg;
    }

    public static synchronized void setMsg(byte[] msg) {
        Message.msg = msg;
    }
}
