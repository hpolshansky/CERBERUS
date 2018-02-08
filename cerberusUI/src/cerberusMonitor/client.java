package cerberusMonitor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

// modeled from: https://www.pegaxchange.com/2017/12/07/simple-tcp-ip-server-client-java/
public class Client implements Runnable {
    private Socket socket;
    private Scanner scanner;
    private Client localClient;

    Client(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
        this.scanner = new Scanner(System.in);
    }

    public void start(Client c1) {
        localClient = c1;
        Thread t2 = new Thread(localClient);
        t2.start();
    }

    public void run(){
        byte[] input;
        try {
            System.out.println("\r\nConnected to: " + localClient.socket.getInetAddress());

            // Client actions
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

    public void sendInput(byte[] input) throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        //out.println(Arrays.toString(input));
        out.write(input[0]);
        out.write(input[1]);
        out.write(input[2]);
        out.write(input[3]);
        out.flush();
    }

    public Client getLocalClient(){ return localClient; }

    public Socket getSocket() { return localClient.socket; }
}
