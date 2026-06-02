package arrays;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums) {
        int pivot = nums.length - 2;

        // Step 1: Find pivot
        while (pivot >= 0 && nums[pivot] > nums[pivot + 1]) {
            pivot--;
        }

        // Step 2: If pivot exits, find successor and swap
        if (pivot >= 0) {
            int successor = nums.length - 1;

            while (nums[successor] <= nums[pivot]) {
                successor--;
            }

            swap(nums, pivot, successor);
        }

        // Step 3: Reverse the suffix
        reverse(nums, pivot + 1, nums.length - 1);
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private static void swap(int[] nums, int pivot, int successor) {
        int temp = nums[pivot];
        nums[pivot] = nums[successor];
        nums[successor] = temp;
    }
}