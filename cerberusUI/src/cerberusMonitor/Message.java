package cerberusMonitor;

public class Message {
    private volatile String msg;

    public synchronized String getMsg() {
        return msg;
    }

    public synchronized void setMsg(String msg) {
        this.msg = msg;
    }
}
