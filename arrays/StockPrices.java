package arrays;

import java.util.Arrays;

class Tuple<X, Y> {
    public X x;
    public Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}

public class StockPrices {
    public static Tuple<Integer, Integer> findBuySellStockPrices(int[] stockNums) {// Return None when stock list is
                                                                                   // empty or less than 2
        if (stockNums == null || stockNums.length < 2) {
            return null;
        }

        // Initializations
        int current_buy = stockNums[0];
        int global_sell = stockNums[1];

        // Calculating the global profit
        int global_profit = global_sell - current_buy;

        // Initializing current_profit with minimum value
        int current_profit = Integer.MIN_VALUE;

        // Looping over stocks to find best buy and selling price
        for (int i = 1; i < stockNums.length; i++) {
            // Calculating the current profit
            current_profit = stockNums[i] - current_buy;

            // Current profit is greater than the global profit
            if (current_profit > global_profit) {
                global_profit = current_profit;
                global_sell = stockNums[i];
            }

            // We will always maximise margin relative to the lowest stock price we can find
            // So whenever we find a stock price lower than the current buying price,
            // we adopt it as the current buying price
            if (current_buy > stockNums[i]) {
                current_buy = stockNums[i];
            }
        }

        // Tuple having buy price and sell price
        Tuple<Integer, Integer> result = new Tuple<Integer, Integer>(global_sell - global_profit, global_sell);

        return result;
    }

    public static void main(String[] args) {

        int[][] stockNums = { { 1, 2, 3, 4, 3, 2, 1, 2, 5 }, { 8, 6, 5, 4, 3, 2, 1 }, { 12, 30, 40, 90, 110 }, { 2 } };

        for (int i = 0; i < stockNums.length; i++) {
            Tuple<Integer, Integer> result = findBuySellStockPrices(stockNums[i]);
            System.out.println((i + 1) + ". Day stocks: " + Arrays.toString(stockNums[i]));
            if (result != null) {
                System.out.println("   Buy Price: " + result.x + ", Sell Price: " + result.y);
            } else {
                System.out.println("   Buy Price: null, Sell Price: null");
            }
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------\n");
        }
    }
}
