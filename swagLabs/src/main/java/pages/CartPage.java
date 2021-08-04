package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage extends AbstractPage {

    private SelenideElement checkoutButton = $x("//button[@data-test = 'checkout']");
    private ElementsCollection removeButton = $$x("//button[contains(@data-test, 'remove')]");
    private SelenideElement cartBadge = $x("//span[@class = 'shopping_cart_badge']");

    public CheckoutStepOnePage clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutStepOnePage();
    }

    public CartPage removeAllProductsFromBasket() {
        removeButton.stream().forEach(a -> a.click());
        return this;
    }

    public boolean isCartBadgeNotExist() {
        return !cartBadge.isDisplayed();
    }

}
