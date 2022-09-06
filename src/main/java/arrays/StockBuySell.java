package main.java.arrays;

public class StockBuySell {
    static int maxProfit(int prices[], int start, int end) {
        int profit = 0;
        if (start >= end) return 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (prices[j] > prices[i]) {
                    int curr_profit = prices[j] - prices[i] + maxProfit(prices, start, i - 1) + maxProfit(prices, j + 1, end);
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }

    static int maxProfitEfficient(int prices[]) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 12};
        System.out.println(maxProfit(arr, 0, arr.length - 1));
        System.out.println(maxProfitEfficient(arr));
    }
}
