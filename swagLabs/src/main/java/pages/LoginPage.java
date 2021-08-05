package pages;

import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private static final String URL = "https://www.saucedemo.com";

    private SelenideElement loginField = $x("//input[@data-test = 'username']");
    private SelenideElement passwordField = $x("//input[@data-test = 'password']");
    private SelenideElement loginButton = $x("//input[@data-test = 'login-button']");

    public LoginPage enterLogin(String login) {
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void openPage() {
        open(URL);
    }

    public InventoryPage loginToAccount(String login){
        enterLogin(login).enterPassword(TestData.password).clickLoginButton();
        return new InventoryPage();
    }

}
