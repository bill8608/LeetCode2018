package bestTimeToBuyAndSellStock;

public class Solution {
    public int maxProfit(int[]prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minBuyPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] - minBuyPrice > maxProfit) {
                maxProfit = prices[i] - minBuyPrice;
            }
            if (prices[i] < minBuyPrice) {
                minBuyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.maxProfit(new int[]{}));
        System.out.println(obj.maxProfit(new int[]{7,}));
        System.out.println(obj.maxProfit(new int[]{7, 3}));
        System.out.println(obj.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(obj.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
