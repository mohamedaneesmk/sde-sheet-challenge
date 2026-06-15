// Count Subarrays with given XOR - Brute Force
/*
 * public class CountSubArrays {
 * public static void main(String[] args) {
 * int[] arr = { 4, 2, 2, 6, 4 };
 * int k = 6;
 * 
 * System.out.println(countSubArrays(arr, k));
 * }
 * 
 * private static int countSubArrays(int[] arr, int k) {
 * int count = 0;
 * 
 * for (int i = 0; i < arr.length; i++) {
 * for (int j = i; j < arr.length; j++) {
 * int xor = 0;
 * for (int x = i; x <= j; x++) {
 * xor = xor ^ arr[x];
 * }
 * if (xor == k) {
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
public class CountSubArrays {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(countSubArrays(arr, k));
    }

    private static int countSubArrays(int[] arr, int k) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor = xor ^ arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }

        return count;
    }
}