package mostlikelyasked;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1};
        System.out.println(
                new CoinChange()
                        .coinChange(coins, 2)
        );
    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;  // means need minimal 0 coins to get amount = 0

        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coin] + 1;
                    } else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }

        return dp[amount];
    }
}
