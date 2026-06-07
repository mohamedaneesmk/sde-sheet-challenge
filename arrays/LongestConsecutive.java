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
