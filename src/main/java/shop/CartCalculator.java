package shop;

public class CartCalculator {

    public double calculateItemTotal(double price, int quantity) {
        return price * quantity;
    }

    public double calculateCartTotal(double[] prices, int[] quantities) {
        double total = 0.0;

        for (int i = 0; i < prices.length; i++) {
            total += calculateItemTotal(prices[i], quantities[i]);
        }

        return total;
    }
}