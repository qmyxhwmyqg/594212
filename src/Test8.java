import java.util.ArrayList;
import java.util.Scanner;

public class Test8 {
    private ArrayList<Product> Products;

    public Test8() {
        Products = new ArrayList<>();
    }

    public void addProduct(int id, String name, double price) {
        Product Product = new Product(id, name, price);
        Products.add(Product);
        System.out.println("成功");
    }

    public Product check(int id) {
        int i;
        for (i = 0; i < Products.size(); i++) {
            Product product = Products.get(i);
            if (product.getId() == id) {
                return product;
            }
        }
        System.out.println("没有查找到该商品");
        return null;
    }

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean a=true;
        while (a){
            System.out.println("1.添加商品");
            System.out.println("2.查询商品");
            System.out.println("3.退出");
            System.out.println("请输入");
        int choice=scanner.nextInt();
        switch (choice){
            case 1:
                System.out.println("请输入商品id");
                int id = scanner.nextInt();
                System.out.println("请输入商品名称");
                String name = scanner.next();
                System.out.println("请输入商品价格");
                double price = scanner.nextDouble();
                addProduct(id, name, price);
                break;
            case 2:
                System.out.println("请输入商品id");
                int ID=scanner.nextInt();
                Product product = check(ID);
                if(product!=null){
                    System.out.println("商品id:"+product.getId());
                    System.out.println("商品名称:"+product.getName());
                    System.out.println("商品价格:"+product.getPrice());
                }
                break;
            case 3:
                a=false;
                break;
            default:
                System.out.println("非法输入");
            }
        }
    }
}