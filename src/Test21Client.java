import java.io.*;
import java.net.*;

public class Test21Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Server!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            System.out.println("服务器响应: " + in.readLine());

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}