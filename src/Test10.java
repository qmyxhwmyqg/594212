import java.lang.reflect.Method;
import java.util.Scanner;
public class Test10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        try {
            Class<?> bankAccountClass = Class.forName("BankAccount");
            System.out.println("请设置余额：");
            int a=scanner.nextInt();
            System.out.println("请输入存款：");
            int b=scanner.nextInt();
            Object account = bankAccountClass.getConstructor(int.class).newInstance(a);
            Method depositMethod = bankAccountClass.getDeclaredMethod("deposit", int.class);
            depositMethod.invoke(account,b);
            Method checkBalanceMethod = bankAccountClass.getDeclaredMethod("checkBalance");
            checkBalanceMethod.invoke(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
