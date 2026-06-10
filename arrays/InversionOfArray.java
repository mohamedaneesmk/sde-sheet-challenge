/* BRUTE FORCE
 * public class InversionOfArray {
 * public static void main(String[] args) {
 * int[] arr = { 4, 3, 2, 1 };
 * System.out.println(inversionOfArray(arr));
 * }
 * 
 * private static int inversionOfArray(int[] arr) {
 * int len = arr.length;
 * int count = 0;
 * 
 * for (int i = 0; i < len - 1; i++) {
 * for (int j = i + 1; j < len; j++) {
 * if (arr[i] > arr[j]) {
 * count++;
 * }
 * }
 * }
 * 
 * return count;
 * }
 * }
 */

// BETTER SOLUTION
public class InversionOfArray {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        System.out.println(inversionOfArray(arr));
    }

    private static int inversionOfArray(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int smaller = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    smaller++;
                }
            }

            count += smaller;
        }

        return count;
    }
}