import java.io.*;

import java.net.Socket;


public class Client {
    private static Socket socket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    private static void pushMessage(String word) {
        try {
            out.write(word + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeClient() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init(String host, int port) {
        try {
            socket = new Socket(host, port);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        boolean isIsShouldBeClose = true;
        try {
            init("localhost", 2000);
            while (isIsShouldBeClose) {
                System.out.println("Write you massage:");
                String word = reader.readLine();
                pushMessage(word);
                System.out.println(in.readLine());
                if (word.equals("exit")) {
                    isIsShouldBeClose = false;
                    System.out.println("Client closed");
                    closeClient();
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
