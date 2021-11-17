import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket; //сокет для общения
    private static ServerSocket serverSocket; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    private static void closeServer() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void pushMessage(String word) {
        try {
            out.write("Echo : " + word + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            System.out.println("Server started!");
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        boolean isIsShouldBeClose = true;
        try {
            init(2000);
            while (isIsShouldBeClose) {
                String word = in.readLine();
                System.out.println(word);
                if (word.equals("exit")) {
                    isIsShouldBeClose = false;
                    pushMessage("Server will be close");
                    System.out.println("Server closed!");
                    closeServer();
                } else {
                    pushMessage(word);
                }
            }

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

