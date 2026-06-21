import java.util.HashMap;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, -10};
        int k = 15;

        System.out.println(longestSubarray(nums, k));
    }

    private static int longestSubarray(int[] nums, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum == k) {
                maxLength = i + 1;
            }

            long remainder = sum - k;

            if (map.containsKey(remainder)) {
                maxLength = Math.max(maxLength, i - map.get(remainder));
            }

            map.putIfAbsent(sum, i);
        }
        return maxLength;
    }
}
