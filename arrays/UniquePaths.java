public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(findUniquePaths(m, n));
    }

    static int[][] memo;

    private static int findUniquePaths(int m, int n) {
        memo = new int[m + 1][n + 1];
        return solve(1, 1, m, n);
    }

    private static int solve(int row, int col, int m, int n) {
        if (row == m && col == n) {
            return 1;
        }

        if (row > m || col > n) {
            return 0;
        }

        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        memo[row][col] = solve(row, col + 1, m, n) + solve(row + 1, col, m, n);

        return memo[row][col];
    }
}
