package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.CartPage;
import pages.CheckoutStepTwoPage;
import pages.InventoryPage;
import pages.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.Products.*;
import static utils.TestData.*;

public class SwagLabsTests extends BaseWebTest {

    private LoginPage loginPage = new LoginPage();
    private InventoryPage inventoryPage = new InventoryPage();

    @BeforeEach
    public void login() {
        loginPage.openPage();
    }

    public static Object[] loginValue() {
        return new Object[]{standardUser, lockedOutUser, problemUser, performanceGlitchUser};
    }

    @ParameterizedTest
    @MethodSource("loginValue")
    public void loginTest(String value) {
        loginPage.loginToAccount(value);

        Assertions.assertEquals(InventoryPage.URL,
                getWebDriver().getCurrentUrl(),"Wrong address");
    }

    @ParameterizedTest
    @MethodSource("loginValue")
    public void buyTest(String value) {
        loginPage.loginToAccount(value);
        String actual = inventoryPage.clickAddingButton(SAUCE_LABS_BACKPACK)
                .clickAddingButton(SAUCE_LABS_BIKE_LIGHT)
                .clickAddingButton(SAUCE_LABS_BOLT_T_SHIRT)
                .clickAddingButton(SAUCE_LABS_FLEECE_JACKET)
                .clickAddingButton(SAUCE_LABS_ONESIE)
                .clickAddingButton(ALL_THE_THINGS)
                .clickBasketButton()
                .clickCheckoutButton()
                .enterFieldForCheckout(map)
                .clickContinueButton()
                .clickFinishButton()
                .getSuccessfullyOrderText();

        Assertions.assertEquals(welcomeMessage, actual,"Buy failed");
    }

    @ParameterizedTest
    @MethodSource("loginValue")
    public void cancelBuyTest(String value) {
        loginPage.loginToAccount(value);
        inventoryPage.clickAddingButton(SAUCE_LABS_BACKPACK)
                .clickAddingButton(SAUCE_LABS_BIKE_LIGHT)
                .clickAddingButton(SAUCE_LABS_BOLT_T_SHIRT)
                .clickAddingButton(SAUCE_LABS_FLEECE_JACKET)
                .clickAddingButton(SAUCE_LABS_ONESIE)
                .clickAddingButton(ALL_THE_THINGS)
                .clickBasketButton()
                .clickCheckoutButton()
                .enterFieldForCheckout(map)
                .clickContinueButton()
                .clickCancelButton();

        Assertions.assertEquals(InventoryPage.URL, getWebDriver().getCurrentUrl(),
                "Wrong inventory address");
    }

    @ParameterizedTest
    @MethodSource("loginValue")
    public void removingProductsTest(String value) {
        loginPage.loginToAccount(value);
        inventoryPage.clickAddingButton(SAUCE_LABS_BACKPACK)
                .clickAddingButton(SAUCE_LABS_BIKE_LIGHT)
                .clickAddingButton(SAUCE_LABS_BOLT_T_SHIRT)
                .clickAddingButton(SAUCE_LABS_FLEECE_JACKET)
                .clickAddingButton(SAUCE_LABS_ONESIE)
                .clickAddingButton(ALL_THE_THINGS)
                .clickBasketButton()
                .removeAllProductsFromBasket();

        Assertions.assertTrue(new CartPage().isCartBadgeNotExist(),
                "The basket has products");
    }

    @ParameterizedTest
    @MethodSource("loginValue")
    public void sumProductsTest(String value) {
        loginPage.loginToAccount(value);
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage();
        inventoryPage.clickAddingButton(SAUCE_LABS_BACKPACK)
                .clickAddingButton(SAUCE_LABS_BIKE_LIGHT)
                .clickAddingButton(SAUCE_LABS_BOLT_T_SHIRT)
                .clickAddingButton(SAUCE_LABS_FLEECE_JACKET)
                .clickAddingButton(SAUCE_LABS_ONESIE)
                .clickAddingButton(ALL_THE_THINGS)
                .clickBasketButton()
                .clickCheckoutButton()
                .enterFieldForCheckout(map)
                .clickContinueButton();

        Assertions.assertEquals(checkoutStepTwoPage.sumOrder(), checkoutStepTwoPage.getTotalSum(),
                "Sum doesn't match");
    }

}
