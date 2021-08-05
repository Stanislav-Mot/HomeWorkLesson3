package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class CheckoutStepOnePage extends AbstractPage{

    private SelenideElement firstName = $x("//input[@data-test = 'firstName']");
    private SelenideElement lastName = $x("//input[@data-test = 'lastName']");
    private SelenideElement postalCode = $x("//input[@data-test = 'postalCode']");
    private SelenideElement continueButton = $x("//input[@data-test = 'continue']");

    public CheckoutStepOnePage enterFieldForCheckout(Map<String, String> map) {
        firstName.sendKeys(map.get("First_Name"));
        lastName.sendKeys(map.get("Last_Name"));
        postalCode.sendKeys(map.get("Zip_Code"));
        return this;
    }

    public CheckoutStepTwoPage clickContinueButton() {
        continueButton.click();
        return new CheckoutStepTwoPage();
    }

}
