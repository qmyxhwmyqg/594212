import java.util.*;

public class Test27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();

        System.out.println("请输入整数(输入-1结束):");
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            set.add(num);
        }

        System.out.println("排序结果: " + set);
        scanner.close();
    }
}