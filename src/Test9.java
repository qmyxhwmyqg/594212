import java.util.Scanner;

public class Test9 {
    // 检查数字是否为负数，如果是则抛出异常
    public static void checkNumber(double number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException(number);
        }
        System.out.println("输入正确：数字 " + number + " 是正数或零");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("请输入一个非负数：");
            double input = scanner.nextDouble();

            checkNumber(input);

        } catch (NegativeNumberException e) {
            System.out.println("捕获到自定义异常：" + e.getMessage());
        } catch (Exception e) {
            System.out.println("发生其他异常：" + e.getMessage());
        } finally {
            System.out.println("程序执行完成");
            scanner.close();
        }
    }
}
