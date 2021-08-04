package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutCompletePage {
    private SelenideElement textCompleteOrder = $x("//h2[@class = 'complete-header']");

    public String getSuccessfullyOrderText() {
        return textCompleteOrder.getText();
    }
}
