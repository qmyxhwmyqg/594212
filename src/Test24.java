import java.io.*;
import java.util.Properties;

public class Test24 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try {
            FileInputStream input = new FileInputStream("config.properties");
            prop.load(input);

            String username = prop.getProperty("username");
            String password = prop.getProperty("password");

            System.out.println("用户名: " + username);
            System.out.println("密码: " + password);

            input.close();
        } catch (IOException e) {
            System.out.println("配置文件不存在，创建默认配置...");
            try {
                FileOutputStream output = new FileOutputStream("config.properties");
                prop.setProperty("username", "admin");
                prop.setProperty("password", "123456");
                prop.store(output, "配置文件");
                output.close();
                System.out.println("默认配置已创建");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}