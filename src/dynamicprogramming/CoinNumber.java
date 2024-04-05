package dynamicprogramming;

import java.util.*;

public class CoinNumber {

    // todo Given a set of coins with different denominations and a target amount, find the minimum number of coins needed to make up that amount.
    public int minimum(int[] coins, int total) {

        int[] coinsNeeded = new int[total + 1];
        Arrays.fill(coinsNeeded, total + 1);

        coinsNeeded[0] = 0;

        for (int i = 1; i <= total; i++) {
            for (int coin : coins) {
                if (coin < i) {
                    coinsNeeded[i] = Math.min(coinsNeeded[i], coinsNeeded[i - coin] + 1);
                }
            }
        }

        return coinsNeeded[total] > total ? -1 : coinsNeeded[total];
    }

}
