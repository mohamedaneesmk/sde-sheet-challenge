/*
public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = findLongestConsecutive(nums);
        System.out.println(result);
    }

    // BRUTE FORCE SOLUTION
    private static int findLongestConsecutive(int[] nums) {
        int longest = 1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            count = 1;

            while (linearSearch(nums, x + 1) == true) {
                x = x + 1;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    private static boolean linearSearch(int[] nums, int x) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                return true;
            }
        }

        return false;
    }

}
*/

// BETTER 

import java.util.Arrays;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = findLongestConsecutive(nums);
        System.out.println(result);
    }

    private static int findLongestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        
        int count = 0;
        int longest = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }
}