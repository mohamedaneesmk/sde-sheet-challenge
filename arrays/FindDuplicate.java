// import java.util.Arrays;

// import java.util.HashMap;
// import java.util.Map;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 3, 4, 2 };
        System.out.println(findDuplicate(nums));
    }

    // USING LINKED LIST
    private static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    /*
     * HASHMAP SOLUTION
     * private static int findDuplicate(int[] nums) {
     * Map<Integer,Integer> map = new HashMap<>();
     * 
     * for(int num : nums){
     * map.put(num, map.getOrDefault(num, 0) + 1);
     * }
     * 
     * for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
     * if (entry.getValue() > 1) {
     * return entry.getKey();
     * }
     * }
     * return -1;
     * }
     */

    /*
     * BRUTE FORCE SOLUTION
     * private static int findDuplicate(int[] nums) {
     * Arrays.sort(nums);
     * for (int i = 0; i < nums.length; i++) {
     * for (int j = i + 1; j < nums.length; j++) {
     * if (nums[i] == nums[j]) {
     * return nums[i];
     * }
     * }
     * }
     * 
     * return -1;
     * }
     */

}
