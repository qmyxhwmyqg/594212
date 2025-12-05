import java.lang.reflect.*;

public class Test19 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.util.ArrayList");

            System.out.println("类名: " + clazz.getName());

            System.out.println("\n所有方法:");
            Method[] methods = clazz.getDeclaredMethods();
            for (int i = 0; i < Math.min(5, methods.length); i++) {
                System.out.println(methods[i]);
            }

            System.out.println("\n所有字段:");
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < Math.min(5, fields.length); i++) {
                System.out.println(fields[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}