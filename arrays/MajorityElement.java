public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
    }

    // Boyer-Moore Voting Algorithm
    private static int majorityElement(int[] nums) {
        int count = 0;
        int candiate = 0;

        for (int num : nums) {
            if (count == 0) {
                candiate = num;
            }

            if (num == candiate) {
                count++;
            } else {
                count--;
            }
        }

        return candiate;
    }

    // BRUTE FORCE SOLUTION
    /*
     * private static int majorityElement(int[] nums) {
     * for (int i = 0; i < nums.length; i++) {
     * int count = 0;
     * for (int j = i; j < nums.length; j++) {
     * if (nums[j] == nums[i]) {
     * count++;
     * }
     * }
     * 
     * if (count > nums.length / 2) {
     * return nums[i];
     * }
     * }
     * 
     * return -1;
     * }
     */

}
