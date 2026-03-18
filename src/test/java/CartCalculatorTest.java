package shop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartCalculatorTest {

    CartCalculator calculator = new CartCalculator();

    @Test
    void testCalculateItemTotal() {
        double result = calculator.calculateItemTotal(10.0, 3);
        assertEquals(30.0, result, 0.001);
    }

    @Test
    void testCalculateCartTotal() {
        double[] prices = {10.0, 5.5, 20.0};
        int[] quantities = {2, 4, 1};

        double result = calculator.calculateCartTotal(prices, quantities);

        assertEquals(62.0, result, 0.001);
    }

    @Test
    void testCalculateCartTotalEmpty() {
        double[] prices = {};
        int[] quantities = {};

        double result = calculator.calculateCartTotal(prices, quantities);

        assertEquals(0.0, result, 0.001);

    }@Test
    void testZeroQuantity() {
        double result = calculator.calculateItemTotal(10.0, 0);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void testZeroPrice() {
        double result = calculator.calculateItemTotal(0.0, 5);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    void testSingleItemCart() {
        double[] prices = {15.0};
        int[] quantities = {2};

        double result = calculator.calculateCartTotal(prices, quantities);

        assertEquals(30.0, result, 0.001);
    }

    @Test
    void testLargeValues() {
        double[] prices = {100.0, 200.0};
        int[] quantities = {10, 5};

        double result = calculator.calculateCartTotal(prices, quantities);

        assertEquals(1000.0 + 1000.0, result, 0.001);
    }

}