package shop;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ShoppingCartController {

    @FXML private Label languageLabel;
    @FXML private ComboBox<String> languageComboBox;
    @FXML private Button confirmLanguageButton;
    @FXML private Label itemCountLabel;
    @FXML private TextField itemCountField;
    @FXML private Button generateItemsButton;
    @FXML private VBox itemsContainer;
    @FXML private Button calculateButton;
    @FXML private Label totalLabel;
    @FXML private Label resultLabel;

    private final CartCalculator calculator = new CartCalculator();
    private Map<String, String> messages;
    private String currentLanguage = "en";

    @FXML
    public void initialize() {
        languageComboBox.setItems(FXCollections.observableArrayList(
                "English", "Finnish", "Swedish", "Japanese", "Arabic"
        ));
    }

    public void setLocalization(Map<String, String> messages, String language) {
        this.messages = messages;
        this.currentLanguage = language;

        languageLabel.setText(messages.getOrDefault("language.label", "Select Language"));
        confirmLanguageButton.setText(messages.getOrDefault("confirm.language", "Confirm Language"));
        itemCountLabel.setText(messages.getOrDefault("item.count.label", "Enter Item Count"));
        itemCountField.setPromptText(messages.getOrDefault("item.count.prompt", "Enter number of items"));
        generateItemsButton.setText(messages.getOrDefault("generate.button", "Generate Items"));
        calculateButton.setText(messages.getOrDefault("calculate.button", "Calculate Total"));
        totalLabel.setText(messages.getOrDefault("total.label", "Total Cost"));
        resultLabel.setText("");

        if ("fi".equals(language)) {
            languageComboBox.setValue("Finnish");
        } else if ("sv".equals(language)) {
            languageComboBox.setValue("Swedish");
        } else if ("ja".equals(language)) {
            languageComboBox.setValue("Japanese");
        } else if ("ar".equals(language)) {
            languageComboBox.setValue("Arabic");
        } else {
            languageComboBox.setValue("English");
        }
    }

    @FXML
    private void handleLanguageChange() {
        try {
            String selected = languageComboBox.getValue();
            Locale locale;

            switch (selected) {
                case "Finnish":
                    locale = new Locale("fi", "FI");
                    break;
                case "Swedish":
                    locale = new Locale("sv", "SE");
                    break;
                case "Japanese":
                    locale = new Locale("ja", "JP");
                    break;
                case "Arabic":
                    locale = new Locale("ar", "AR");
                    break;
                default:
                    locale = new Locale("en", "US");
                    break;
            }

            Stage stage = (Stage) languageComboBox.getScene().getWindow();
            ShoppingCartApp.loadScene(stage, locale);

        } catch (Exception e) {
            e.printStackTrace();
            if (messages != null) {
                resultLabel.setText(messages.getOrDefault("language.change.failed", "Language change failed"));
            } else {
                resultLabel.setText("Language change failed");
            }
        }
    }

    @FXML
    private void handleGenerateItems() {
        itemsContainer.getChildren().clear();

        try {
            int itemCount = Integer.parseInt(itemCountField.getText());

            for (int i = 1; i <= itemCount; i++) {
                Label itemLabel = new Label(messages.getOrDefault("item.label", "Item") + " " + i);

                TextField priceField = new TextField();
                priceField.setPromptText(messages.getOrDefault("price.prompt", "Enter price"));

                TextField quantityField = new TextField();
                quantityField.setPromptText(messages.getOrDefault("quantity.prompt", "Enter quantity"));

                HBox row = new HBox(10, itemLabel, priceField, quantityField);
                itemsContainer.getChildren().add(row);
            }

        } catch (NumberFormatException e) {
            resultLabel.setText(messages.getOrDefault("invalid.number", "Invalid number"));
        }
    }

    @FXML
    private void handleCalculate() {
        List<Double> prices = new ArrayList<>();
        List<Integer> quantities = new ArrayList<>();

        try {
            for (Node node : itemsContainer.getChildren()) {
                if (node instanceof HBox row) {
                    TextField priceField = (TextField) row.getChildren().get(1);
                    TextField quantityField = (TextField) row.getChildren().get(2);

                    double price = Double.parseDouble(priceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());

                    prices.add(price);
                    quantities.add(quantity);
                }
            }

            double total = calculator.calculateCartTotal(prices, quantities);
            resultLabel.setText(String.format("%.2f", total));

            int cartId = CartService.saveCart(prices.size(), total, currentLanguage);

            for (int i = 0; i < prices.size(); i++) {
                double subtotal = calculator.calculateItemTotal(prices.get(i), quantities.get(i));
                CartService.saveCartItem(cartId, i + 1, prices.get(i), quantities.get(i), subtotal);
            }

        } catch (Exception e) {
            e.printStackTrace();
            resultLabel.setText(messages.getOrDefault("invalid.input", "Invalid input"));
        }
    }
}