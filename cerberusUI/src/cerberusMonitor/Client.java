package cerberusMonitor;

import sun.security.ssl.Debug;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import static cerberusMonitor.Main.monitorController;

// modeled from: https://www.pegaxchange.com/2017/12/07/simple-tcp-ip-server-client-java/
public class Client implements Runnable {
    private Socket socket;
    private Client localClient;
    private volatile boolean exit = false;
    private Thread t2;

    // constructor
    Client(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
    }

    // thread starts on application startup
    public void start(Client c1) {
        localClient = c1;
        t2 = new Thread(localClient);
        t2.start();
    }

    // main thread functionality
    public void run(){
        byte[] input;
        byte[] pinput = null;

        try {
            System.out.println("\r\nConnected to: " + localClient.socket.getInetAddress());

            // Client actions
            while (!exit) {
                input = Message.getMsg();

                System.out.println("Recv: " + Arrays.toString(getInput()));
                if(getInput()[0] == 0) {
                    // set FXML to show disconnection
                    monitorController.serverStatus(false);
                    // close server port and this client
                    stop();
                    localClient.socket.close();
                    this.socket.close();
                }
                if(input != null) { // new message sent
                    sendInput(input); // send it
                    pinput = input;
                    Message.setMsg(null); // clear msg
                }
                else if (pinput != null){ // no new messages
                    sendInput(pinput); // send previous message
                    Message.setMsg(null); // clear msg
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void stop() {
        exit = true;
    }

    private void sendInput(byte[] input) throws IOException {
        OutputStream out = this.socket.getOutputStream();
        for(int i=0;i<input.length;i++) {
            if(input.length!=6) {
                int a = 5;
            }
            out.write(input[i]);
        }
        out.flush();
    }

    private byte[] getInput() throws IOException {
        InputStream in = this.socket.getInputStream();
        byte[] hero_msg = new byte[3];
        in.read(hero_msg, 0, hero_msg.length);
        return hero_msg;
    }

    public Client getLocalClient(){ return localClient; }

    public void setLocalClient(Client localClient) {
        this.localClient = localClient;
    }

    public Socket getSocket() { return localClient.socket; }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Thread getT2() {
        return t2;
    }
}