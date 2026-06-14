import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(findUniquePaths(m, n));
    }

    private static int findUniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // base: first row all 1s

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // dp[j] = from above, dp[j-1] = from left
            }
        }
        return dp[n - 1];
    }
}
