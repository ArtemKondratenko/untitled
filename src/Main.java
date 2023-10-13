import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        int port = 6677;
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Под ключение к " + "localhost" + " на порт " + port);
            Socket client = new Socket("localhost", port);
            while (true) {
                String com = sc.nextLine();
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);
                out.writeUTF(com);
                DataInputStream in = new DataInputStream(client.getInputStream());
                System.out.println(in.readUTF());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}