import java.io.*;
import java.util.*;

public class Test30 {
    private Map<String, BankAccount30> accounts;
    private static final String FILE_NAME = "bank_accounts.txt";
    public Test30() {
        accounts = new HashMap<>();
        loadAccountsFromFile();
    }
    public synchronized boolean createAccount(String accountId, String userName, double initialBalance) {
        if (accounts.containsKey(accountId)) {
            return false; // 账户ID已存在
        }
        BankAccount30 account = new BankAccount30(accountId, userName, initialBalance);
        accounts.put(accountId, account);
        saveAccountsToFile();
        return true;
    }
    public boolean deposit(String accountId, double amount) {
        BankAccount30 account = accounts.get(accountId);
        if (account == null) {
            return false;
        }
        synchronized (account) {
            account.deposit(amount);
            saveAccountsToFile();
            return true;
        }
    }
    public boolean withdraw(String accountId, double amount) {
        BankAccount30 account = accounts.get(accountId);
        if (account == null) {
            return false;
        }
        synchronized (account) {
            boolean success = account.withdraw(amount);
            if (success) {
                saveAccountsToFile();
            }
            return success;
        }
    }
    public Double getBalance(String accountId) {
        BankAccount30 account = accounts.get(accountId);
        if (account == null) {
            return null;
        }
        synchronized (account) {
            return account.getBalance();
        }
    }
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("暂无账户");
            return;
        }
        System.out.println("\n=== 所有账户信息 ===");
        System.out.println("========================================");
        int i = 1;
        for (BankAccount30 account : accounts.values()) {
            System.out.println(i + ". " + account);
            i++;
        }
        System.out.println("========================================");
        System.out.println("总计: " + accounts.size() + " 个账户");
    }
    private synchronized void saveAccountsToFile() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            for (BankAccount30 account : accounts.values()) {
                writer.write(account.toCSV() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("保存文件失败: " + e.getMessage());
        }
    }
    private void loadAccountsFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                BankAccount30 account = BankAccount30.fromCSV(line);
                if (account != null) {
                    accounts.put(account.getAccountId(), account);
                }
            }
            reader.close();
            System.out.println("已从文件加载 " + accounts.size() + " 个账户");
        } catch (IOException e) {
            System.out.println("读取文件失败: " + e.getMessage());
        }
    }
    private void displayMenu() {
        System.out.println("\n=== 银行账户管理系统 ===");
        System.out.println("1. 创建账户");
        System.out.println("2. 存款");
        System.out.println("3. 取款");
        System.out.println("4. 查询余额");
        System.out.println("5. 显示所有账户");
        System.out.println("6. 多线程测试");
        System.out.println("7. 退出系统");
        System.out.print("请选择操作(1-7): ");
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("请输入账户ID: ");
                    String accountId = scanner.nextLine();
                    System.out.print("请输入用户名: ");
                    String userName = scanner.nextLine();
                    System.out.print("请输入初始余额: ");
                    double initialBalance = scanner.nextDouble();
                    if (createAccount(accountId, userName, initialBalance)) {
                        System.out.println("账户创建成功");
                    } else {
                        System.out.println("账户创建失败，账户ID已存在");
                    }
                    break;
                case 2:
                    System.out.print("请输入账户ID: ");
                    String depositAccountId = scanner.nextLine();
                    System.out.print("请输入存款金额: ");
                    double depositAmount = scanner.nextDouble();
                    if (deposit(depositAccountId, depositAmount)) {
                        System.out.println("存款成功");
                    } else {
                        System.out.println("存款失败，账户不存在");
                    }
                    break;
                case 3:
                    System.out.print("请输入账户ID: ");
                    String withdrawAccountId = scanner.nextLine();
                    System.out.print("请输入取款金额: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdraw(withdrawAccountId, withdrawAmount)) {
                        System.out.println("取款成功");
                    } else {
                        System.out.println("取款失败，账户不存在或余额不足");
                    }
                    break;
                case 4:
                    System.out.print("请输入账户ID: ");
                    String queryAccountId = scanner.nextLine();
                    Double balance = getBalance(queryAccountId);
                    if (balance != null) {
                        System.out.printf("账户余额: %.2f\n", balance);
                    } else {
                        System.out.println("账户不存在");
                    }
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 6:
                    testMultiThread();
                    break;
                case 7:
                    running = false;
                    System.out.println("感谢使用银行账户管理系统！");
                    break;
                default:
                    System.out.println("无效选择，请重新输入");
            }
        }
        scanner.close();
    }
    private void testMultiThread() {
        System.out.println("\n=== 多线程测试 ===");
        String testAccountId = "TEST001";
        if (!accounts.containsKey(testAccountId)) {
            createAccount(testAccountId, "测试用户", 1000.0);
            System.out.println("创建测试账户: " + testAccountId + "，初始余额: 1000.0");
        }
        Thread[] threads = new Thread[5];
        threads[0] = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                deposit(testAccountId, 100);
                System.out.println(Thread.currentThread().getName() + " 存款100");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        }, "存款线程1");
        threads[1] = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                deposit(testAccountId, 200);
                System.out.println(Thread.currentThread().getName() + " 存款200");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        }, "存款线程2");
        threads[2] = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                withdraw(testAccountId, 50);
                System.out.println(Thread.currentThread().getName() + " 取款50");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        }, "取款线程1");
        threads[3] = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                withdraw(testAccountId, 100);
                System.out.println(Thread.currentThread().getName() + " 取款100");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        }, "取款线程2");
        threads[4] = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                Double balance = getBalance(testAccountId);
                System.out.println(Thread.currentThread().getName() +
                        " 查询余额: " + balance);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        }, "查询线程");
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Double finalBalance = getBalance(testAccountId);
        System.out.println("\n多线程测试完成");
        System.out.println("最终余额应为: 1000 + 300 + 600 - 100 - 200 = 1600");
        System.out.printf("实际最终余额: %.2f\n", finalBalance);
        System.out.println("余额正确: " + (Math.abs(finalBalance - 1600) < 0.01));
    }
    public static void main(String[] args) {
        Test30 bankSystem = new Test30();
        bankSystem.run();
    }
}