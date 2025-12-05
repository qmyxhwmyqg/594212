import java.io.*;
import java.util.Scanner;

public class Test11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要写入文件的内容: ");
        String content = scanner.nextLine();
        try {
            FileWriter writer = new FileWriter("test.txt");
            writer.write(content);
            writer.close();
            System.out.println("内容已写入文件");
            System.out.println("\n从文件中读取的内容:");
            FileReader reader = new FileReader("test.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}