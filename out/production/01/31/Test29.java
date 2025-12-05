import java.io.*;
import java.util.*;

public class Test29 {
    private ArrayList<Book> books;
    private static final String FILE_NAME = "books.txt";
    public Test29() {
        books = new ArrayList<>();
        loadBooksFromFile();
    }
    public void addBook(String isbn, String title, String author, int stock) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                System.out.println("ISBN已存在，添加失败");
                return;
            }
        }
        Book book = new Book(isbn, title, author, stock);
        books.add(book);
        saveBooksToFile();
        System.out.println("添加成功");
    }
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("暂无图书");
            return;
        }
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getIsbn().compareTo(b2.getIsbn());
            }
        });
        System.out.println("\n=== 所有图书信息 ===");
        System.out.println("==============================================================");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
        System.out.println("==============================================================");
    }
    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.borrowBook()) {
                    saveBooksToFile();
                    System.out.println("借书成功！");
                } else {
                    System.out.println("库存不足，借书失败");
                }
                return;
            }
        }
        System.out.println("未找到ISBN为 " + isbn + " 的图书");
    }
    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.returnBook();
                saveBooksToFile();
                System.out.println("还书成功！");
                return;
            }
        }
        System.out.println("未找到ISBN为 " + isbn + " 的图书");
    }
    private void saveBooksToFile() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            for (Book book : books) {
                writer.write(book.toCSV() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("保存文件失败: " + e.getMessage());
        }
    }
    private void loadBooksFromFile() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = Book.fromCSV(line);
                if (book != null) {
                    books.add(book);
                }
            }
            reader.close();
            System.out.println("已从文件加载 " + books.size() + " 本图书");
        } catch (IOException e) {
            System.out.println("读取文件失败: " + e.getMessage());
        }
    }
    private void displayMenu() {
        System.out.println("\n=== 图书管理系统 ===");
        System.out.println("1. 添加图书");
        System.out.println("2. 查看所有图书");
        System.out.println("3. 借书");
        System.out.println("4. 还书");
        System.out.println("5. 退出系统");
        System.out.print("请选择操作(1-5): ");
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
                    System.out.print("请输入ISBN编号: ");
                    String isbn = scanner.nextLine();
                    System.out.print("请输入书名: ");
                    String title = scanner.nextLine();
                    System.out.print("请输入作者: ");
                    String author = scanner.nextLine();
                    System.out.print("请输入库存数量: ");
                    int stock = scanner.nextInt();
                    addBook(isbn, title, author, stock);
                    break;
                case 2:
                    displayAllBooks();
                    break;
                case 3:
                    System.out.print("请输入要借阅的图书ISBN编号: ");
                    String borrowIsbn = scanner.nextLine();
                    borrowBook(borrowIsbn);
                    break;
                case 4:
                    System.out.print("请输入要归还的图书ISBN编号: ");
                    String returnIsbn = scanner.nextLine();
                    returnBook(returnIsbn);
                    break;
                case 5:
                    running = false;
                    System.out.println("感谢使用图书管理系统！");
                    break;
                default:
                    System.out.println("无效选择，请重新输入");
            }
        }
        scanner.close();
    }
    public static void main(String[] args) {
        Test29 library = new Test29();
        library.run();
    }
}