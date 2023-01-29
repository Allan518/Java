public class GiftCards {

    public static int coinCombination(int m, int n) {
        // base case: if m is less than n*10, return 0
        if (m < n * 10) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];

        // initialize the first column to 1, as it represents the case of 0 coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // fill the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j]; // case when the coin is not included
                if (j >= 10) {
                    dp[i][j] += dp[i][j - 10];
                }
                if (j >= 30) {
                    dp[i][j] += dp[i][j - 30];
                }
                if (j >= 50) {
                    dp[i][j] += dp[i][j - 50];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int m = 50;
        int n = 2;
        System.out.println(coinCombination(m, n)); // 2 (10+40 or 30+20)
    }
}
