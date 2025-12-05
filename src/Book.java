public class Book {
    private String isbn;
    private String title;
    private String author;
    private int stock;

    public Book(String isbn, String title, String author, int stock) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public boolean borrowBook() {
        if (stock > 0) {
            stock--;
            return true;
        }
        return false;
    }
    public void returnBook() {
        stock++;
    }
    @Override
    public String toString() {
        return String.format("ISBN: %-15s 书名: %-20s 作者: %-15s 库存: %d",
                isbn, title, author, stock);
    }
    public String toCSV() {
        return isbn + "," + title + "," + author + "," + stock;
    }
    public static Book fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length == 4) {
            String isbn = parts[0];
            String title = parts[1];
            String author = parts[2];
            int stock = Integer.parseInt(parts[3]);
            return new Book(isbn, title, author, stock);
        }
        return null;
    }
}
