import java.io.*;
import java.net.*;

public class Test21Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器启动，等待连接...");

            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String message = in.readLine();
            System.out.println("收到客户端消息: " + message);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("服务器已收到: " + message);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
