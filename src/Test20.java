import java.io.*;
import java.util.Scanner;

public class Test20 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("test1.txt"));
            String line;
            int wordCount = 0;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");//适用于英语环境
                wordCount += words.length;
            }
            reader.close();
            System.out.println("单词数量: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}