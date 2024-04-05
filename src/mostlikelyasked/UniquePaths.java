package mostlikelyasked;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(
                new UniquePaths()
                        .uniquePaths(3, 2)
        );
    }

    public int uniquePaths(int m, int n) {

        // use dynamic programming to solve this problem.
        int[][] dp = new int[m][n];
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m == 1 && n == 1) {
            return 2;
        }

        // init all the default path counts
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // init all the dp[i][j]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
