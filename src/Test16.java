import java.util.Arrays;

public class Test16 {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9,11,15,18,19};
        int[] arr2 = {2, 4, 6, 8, 10,12,13,14,16,17,20};
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                k++;i++;
            } else {
                result[k] = arr2[j];
                k++;j++;
            }
        }
        while (i < arr1.length) {
            result[k] = arr1[i];
            k++;i++;
        }
        while (j < arr2.length) {
            result[k] = arr2[j];
            k++;j++;
        }
        System.out.println("合并后数组: " + Arrays.toString(result));
    }
}