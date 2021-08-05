package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutCompletePage extends AbstractPage {
    private SelenideElement textCompleteOrder = $x("//h2[@class = 'complete-header']");

    public String getSuccessfullyOrderText() {
        return textCompleteOrder.getText();
    }
}
