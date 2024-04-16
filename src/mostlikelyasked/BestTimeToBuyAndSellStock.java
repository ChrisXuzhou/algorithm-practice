package mostlikelyasked;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int profit = new BestTimeToBuyAndSellStock()
                .maxProfit(new int[] {2, 1, 4});

        System.out.println(profit);
    }

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        int maxPrice = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i] - minPrice;
            maxPrice = Math.max(currentPrice, maxPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxPrice;
    }
}
