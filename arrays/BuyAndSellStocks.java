public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 3, 6, 4 };
        System.out.println(findProfit(nums));
    }

    private static int findProfit(int[] nums) {
        int maxProfit = Integer.MIN_VALUE;
        int minNum = nums[0];
        int profit = 0;

        for (int i = 1; i < nums.length; i++) {
            int cost = nums[i] - minNum;
            profit = Math.max(maxProfit, cost);
            minNum = Math.min(minNum, nums[i]);
        }

        return profit;
    }
}