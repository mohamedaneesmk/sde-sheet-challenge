public class ReversePairs {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println(findReversePairs(nums)); // Output: 2
    }

    // Entry point
    private static int findReversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    // Step 1: Divide
    private static int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0; // base case: single element

        int mid = low + (high - low) / 2;

        int count = 0;
        count += mergeSort(nums, low, mid);       // sort & count left half
        count += mergeSort(nums, mid + 1, high);  // sort & count right half
        count += countAndMerge(nums, low, mid, high); // count across + merge
        return count;
    }

    // Step 2: Count pairs across halves, then merge
    private static int countAndMerge(int[] nums, int low, int mid, int high) {
        int count = 0;

        // ✅ YOUR LOGIC — count reverse pairs (before merging!)
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2L * nums[right]) {
                // 2L to avoid integer overflow
                right++;
            }
            count += (right - (mid + 1));
        }

        // Merge the two sorted halves
        int[] temp = new int[high - low + 1];
        int left = low, r = mid + 1, k = 0;

        while (left <= mid && r <= high) {
            if (nums[left] <= nums[r]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[r++];
            }
        }
        while (left <= mid)  temp[k++] = nums[left++];
        while (r <= high)    temp[k++] = nums[r++];

        // Copy back to original array
        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }

        return count;
    }
}