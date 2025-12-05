import java.util.Scanner;
public class Test7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请设置余额：");
        int balance = scanner.nextInt();
        BankAccount BankAccount = new BankAccount(balance);
        System.out.println("请输入存款金额：");
        int money1=scanner.nextInt();
        BankAccount.deposit(money1);
        System.out.println("请输入取款金额：");
        int money2=scanner.nextInt();
        BankAccount.withdraw(money2);
        System.out.println("检查账户余额：");
        BankAccount.checkBalance();
    }
}
