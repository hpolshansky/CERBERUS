package cerberusMonitor;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class client implements Runnable {
    private Socket socket;
    private Scanner scanner;
    private client localClient;

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

            while (true) {
                input = scanner.nextLine();
                PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
                out.println(input);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
