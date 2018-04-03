package cerberusMonitor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;

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
        byte[] pinput = null;
//        String input;
        try {
            System.out.println("\r\nConnected to: " + localClient.socket.getInetAddress());

            // Client actions
            while (true) {
//                input = scanner.nextLine();
                input = Message.getMsg();
                if(input != null) { // new message sent
                    sendInput(input); // send it
                    pinput = input;
                    Message.setMsg(null); // clear msg
                }
                else if (pinput != null){ // no new messages
                    sendInput(pinput); // send last message
                    Message.setMsg(null); // clear msg
                }
                System.out.println("Recv: " + Arrays.toString(getInput()));
                if(getInput()[0] == 0x16) {
                    System.out.println("YES!!!");
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendInput(byte[] input) throws IOException {
        OutputStream out = this.socket.getOutputStream();

        for(int i=0;i<input.length;i++)
        {
            if(input.length!=6)
            {
                int a = 5;
            }
            out.write(input[i]);
        }

        out.flush();
    }

    public byte[] getInput() throws IOException {
        InputStream in = this.socket.getInputStream();
        byte[] hero_msg = new byte[1];
        in.read(hero_msg, 0 ,1);
        return hero_msg;
    }

    public Client getLocalClient(){ return localClient; }

    public Socket getSocket() { return localClient.socket; }
}