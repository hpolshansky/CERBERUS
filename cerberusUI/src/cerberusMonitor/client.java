package cerberusMonitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

// modeled from: https://www.pegaxchange.com/2017/12/07/simple-tcp-ip-server-client-java/
public class client implements Runnable {
    private Socket socket;
    private Scanner scanner;
    private client localClient;
    private Message msg = new Message();

    client(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
        this.scanner = new Scanner(System.in);
    }

    public void start(client c1) {
        localClient = c1;
        Thread t2 = new Thread(localClient);
        t2.start();
    }

    public void run(){
        String input;
        try {
            System.out.println("\r\nConnected to: " + localClient.socket.getInetAddress());

            // client actions
            while (true) {
//                input = scanner.nextLine();
                input = Message.getMsg();
                if(input != null) {
                    sendInput(input);
                    Message.setMsg(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendInput(String input) throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        out.println(input);
        out.flush();
    }

    public client getLocalClient(){ return localClient; }

    public Socket getSocket() { return localClient.socket; }
}
