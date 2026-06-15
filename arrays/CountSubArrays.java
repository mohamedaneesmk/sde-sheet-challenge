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
 * int xor = 0;
 * for (int j = i; j < arr.length; j++) {
 * xor = xor ^ arr[j];
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

// Optimal
import java.util.HashMap;

public class CountSubArrays {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        int k = 6;

        System.out.println(countSubArrays(arr, k));
    }

    private static long countSubArrays(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int xor = 0;
        long count = 0;

        map.put(0, 1);

        for (int num : arr) {

            xor = xor ^ num;

            int target = xor ^ k;

            count = count + map.getOrDefault(target, 0) + 1;

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}