public class BankAccount {
    private int balance;
    public BankAccount(int balance) {
        this.balance = balance;
    }
    public void deposit(int money) {
        if (money > 0) {
            balance = balance + money;
        } else {
            System.out.println("ERROR");
        }
    }
    public void withdraw(int money) {
        if (balance >= money) {
            balance = balance - money;
        } else {
            System.out.println("ERROR");
        }
    }
    public void checkBalance(){
        System.out.println(balance);
    }
}