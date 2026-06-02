// BRUTE FORCE 
/* 
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubarray(nums));
    }

    private static int maximumSubarray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) { 
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum = sum + nums[k];
                }
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}
*/

// BETTER
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maximumSubarray(nums));
    }

    private static int maximumSubarray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}
