package shop;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ShoppingCartApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select language / Valitse kieli / Välj språk / 言語を選択してください:");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Locale locale;

        switch (choice) {
            case 2:
                locale = new Locale("fi", "FI");
                break;
            case 3:
                locale = new Locale("sv", "SE");
                break;
            case 4:
                locale = new Locale("ja", "JP");
                break;
            case 1:
            default:
                locale = new Locale("en", "US");
                break;
        }

        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
        CartCalculator calculator = new CartCalculator();

        System.out.print(messages.getString("enter.item.count"));
        int itemCount = scanner.nextInt();

        double totalCartCost = 0.0;

        for (int i = 1; i <= itemCount; i++) {
            System.out.print(messages.getString("enter.price") + " " + i + ": ");
            double price = scanner.nextDouble();

            System.out.print(messages.getString("enter.quantity") + " " + i + ": ");
            int quantity = scanner.nextInt();

            double itemTotal = calculator.calculateItemTotal(price, quantity);
            totalCartCost += itemTotal;

            System.out.println(messages.getString("item.total") + " " + itemTotal);
        }

        System.out.println(messages.getString("cart.total") + " " + totalCartCost);

        scanner.close();
    }
}