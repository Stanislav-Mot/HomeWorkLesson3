package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutStepTwoPage extends AbstractPage{
    private SelenideElement finishButton = $x("//button[@data-test = 'finish']");
    private SelenideElement cancelButton = $x("//button[@data-test = 'cancel']");
    private SelenideElement totalSum = $x("//div[@class = 'summary_subtotal_label']");
    private ElementsCollection inventoryPrice = $$x("//div[@class = 'inventory_item_price']");

    public CheckoutCompletePage clickFinishButton() {
        finishButton.click();
        return new CheckoutCompletePage();
    }

    public InventoryPage clickCancelButton() {
        cancelButton.click();
        return new InventoryPage();
    }

    public List<Double> getInventoryPrices() {
        return inventoryPrice.stream()
                .map(a -> a.getText().replace("$", ""))
                .map(Double::valueOf)
                .collect(Collectors.toList());
    }

    public double sumOrder() {
        return getInventoryPrices().stream().mapToDouble(a -> a).sum();
    }

    public double getTotalSum() {
        return Double.parseDouble(totalSum.getText().split("\\$")[1]);
    }

}
