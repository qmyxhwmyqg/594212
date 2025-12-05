public class BankAccount30 {
    private String accountId;
    private String userName;
    private double balance;
    public BankAccount30(String accountId, String userName, double balance) {
        this.accountId = accountId;
        this.userName = userName;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    public String getAccountId() {
        return accountId;
    }
    public String getUserName() {
        return userName;
    }
    public double getBalance() {
        return balance;
    }
    public String toCSV() {
        return accountId + "," + userName + "," + balance;
    }
    public static BankAccount30 fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length == 3) {
            String accountId = parts[0];
            String userName = parts[1];
            double balance = Double.parseDouble(parts[2]);
            return new BankAccount30(accountId, userName, balance);
        }
        return null;
    }
    @Override
    public String toString() {
        return String.format("账户ID: %s, 用户名: %s, 余额: %.2f",
                accountId, userName, balance);
    }
}
