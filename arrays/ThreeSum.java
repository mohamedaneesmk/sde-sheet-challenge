/*
 * BRUTE FORCE
 * 
 * import java.util.ArrayList;
 * import java.util.Collections;
 * import java.util.List;
 * 
 * public class ThreeSum {
 * public static void main(String[] args) {
 * int[] nums = { -1, 0, 1, 2, -1, -4 };
 * List<List<Integer>> result = threeSum(nums);
 * 
 * System.out.println(result);
 * }
 * 
 * private static List<List<Integer>> threeSum(int[] nums) {
 * List<List<Integer>> result = new ArrayList<>();
 * 
 * for (int i = 0; i < nums.length; i++) {
 * for (int j = i + 1; j < nums.length; j++) {
 * for (int k = j + 1; k < nums.length; k++) {
 * if (nums[i] + nums[j] + nums[k] == 0) {
 * List<Integer> triplet = new ArrayList<>();
 * 
 * triplet.add(nums[i]);
 * triplet.add(nums[j]);
 * triplet.add(nums[k]);
 * 
 * Collections.sort(triplet);
 * 
 * if (!result.contains(triplet)) {
 * result.add(triplet);
 * }
 * }
 * }
 * }
 * }
 * 
 * return result;
 * }
 * }
 */

// OPTIMAL

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum(nums);

        System.out.println(result);
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}