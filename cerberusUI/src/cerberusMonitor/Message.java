package cerberusMonitor;

public class Message {
    private static String msg;

    public static synchronized String getMsg() {
        return msg;
    }

    public static synchronized void setMsg(String msg) {
        Message.msg = msg;
    }
}
