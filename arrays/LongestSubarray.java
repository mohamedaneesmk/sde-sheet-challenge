// BRUTE FORCE
/* public class LongestSubarray {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }

    private static int longestSubarray(int[] arr, int k) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int x = i; x <= j; x++) {
                    sum = sum + arr[x];
                }

                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}
*/

// BETTER SOLUTION
public class LongestSubarray {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        System.out.println(longestSubarray(arr, k));
    }

    private static int longestSubarray(int[] arr, int k) {
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}