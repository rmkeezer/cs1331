public class ArrayUtils {

    public static void main(String[] args) {
        int[] arr1 = {3, 7, 10, 2};
        int[] arr2 = {1, 4, 9, 5};
        int sum = reverseProduct(arr1, arr2);
        System.out.println(sum);
    }

    public static int reverseProduct(int[] a, int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[b.length - i - 1];
        }
        return sum;
    }

}