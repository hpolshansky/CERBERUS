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

    // constructor
    Client(InetAddress serverAddress, int serverPort) throws Exception {
        this.socket = new Socket(serverAddress, serverPort);
    }

    // thread starts on application startup
    public void start(Client c1) {
        localClient = c1;
        Thread t2 = new Thread(localClient);
        t2.start();
    }

    // main thread functionality
    public void run(){
        byte[] input;
        byte[] pinput = null;

        try {
            System.out.println("\r\nConnected to: " + localClient.socket.getInetAddress());

            // Client actions
            while (true) {
                input = Message.getMsg();
                System.out.println("Recv: " + Arrays.toString(getInput()));
                if(getInput()[0] == 0) {
                    System.out.println("SERVER DISCONNECTED");
                    // close server port
                    localClient.socket.close();
//                    // set FXML to show disconnection
                    monitorController.serverStatus(false);
//                    // wait for server connect
                    while(true) {
                        // checks for server connection every 0.1 seconds
                        if (InetAddress.getByName("192.168.1.66").isReachable(10)) {
                            try {
                                System.out.println("Lalala");
                                Client c = new Client(InetAddress.getByName("192.168.1.66"), Integer.parseInt("2000"));
                                c.run();
                                break;
                            } catch (Exception e) {
                                // it's fine; continue
                                System.out.println("waiting...");
                            }

                        }
                    }
                    System.out.println("I'm outtie");
                }
                if(input != null) { // new message sent
                    sendInput(input); // send it
                    pinput = input;
                    Message.setMsg(null); // clear msg
                }
                else if (pinput != null){ // no new messages
                    sendInput(pinput); // send last message
                    Message.setMsg(null); // clear msg
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendInput(byte[] input) throws IOException {
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
}