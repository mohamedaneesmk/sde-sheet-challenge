import java.util.Arrays;

// BRUTE FORCE SOLUTION
public class SortColors {
    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        System.out.println(Arrays.toString(sortColors(nums)));
    }

    private static int[] sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : nums) {
            if (num == 0)
                count0++;
            else if (num == 1)
                count1++;
            else
                count2++;
        }

        int index = 0;

        while (count0 > 0) {
            nums[index++] = 0;
            count0--;
        }

        while (count1 > 0) {
            nums[index++] = 1;
            count1--;
        }

        while (count2 > 0) {
            nums[index++] = 2;
            count2--;
        }

        return nums;
    }
}
