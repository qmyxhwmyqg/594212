public class Test13 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("原始数组:");
        int i;
        for (i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.println("逆序输出:");
        for (i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}