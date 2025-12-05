public class Test14 {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Integer[] intArray = {1, 5, 3, 9, 2};
        Double[] doubleArray = {1.1, 5.5, 3.3, 9.9, 2.2,9.19};
        String[] strArray = {"apple", "banana", "cherry","ck"};
        System.out.println("整数最大值: " + findMax(intArray));
        System.out.println("浮点数最大值: " + findMax(doubleArray));
        System.out.println("字符串最大值: " + findMax(strArray));
    }
}
