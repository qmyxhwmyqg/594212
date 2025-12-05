import java.io.*;
import java.net.*;

public class Test26 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("HTTP服务器启动，端口: 8080");

            while (true) {
                Socket clientSocket = serverSocket.accept();

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request = in.readLine();
                System.out.println("收到请求: " + request);

                // 响应
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type: text/html");
                out.println();
                out.println("<h1>Hello World!</h1>");

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}