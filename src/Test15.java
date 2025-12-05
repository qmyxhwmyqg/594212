import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Test15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("请输入数字(输入-1结束):");
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            list.add(num);
        }
        System.out.println("原始列表: " + list);
        HashSet<Integer> set = new HashSet<>(list);
        ArrayList<Integer> result = new ArrayList<>(set);
        System.out.println("去重后: " + result);
        scanner.close();
    }
}