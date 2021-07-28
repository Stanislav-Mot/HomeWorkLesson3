import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Locators.PageWithLocators.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests extends BaseWebTest {

    Methods methods = new Methods();

    @Test
    @Order(1)
    @DisplayName("Testing for authorization of user")
    public void testLogin() {

        methods.enter(LOGIN_LOCATOR, Constants.EMAIL);
        methods.enter(PASSWORD_LOCATOR, Constants.PASSWORD);
        methods.click(SIGN_IN_BUTTON);

        String userEmail = DRIVER.findElement(PROFILE).getText();
        Assertions.assertEquals(userEmail, Constants.EMAIL, "The user wasn't found or the wrong user");

    }

    @ParameterizedTest
    @EnumSource(State.class)
    @Order(2)
    @DisplayName("Testing for adding an address")
    public void testAddAddress(State state) {

        methods.click(BUTTON_ADDRESSES);
        methods.click(BUTTON_NEW_ADDRESS);
        methods.enter(FIRST_NAME_LOCATOR, Constants.map.get("FIRST_NAME"));
        methods.enter(LAST_NAME_LOCATOR, Constants.map.get("LAST_NAME"));
        methods.enter(ADDRESS1_LOCATOR, Constants.map.get("ADDRESS1"));
        methods.enter(ADDRESS2_LOCATOR, Constants.map.get("ADDRESS2"));
        methods.enter(CITY_LOCATOR, Constants.map.get("CITY"));
        methods.click(STATE_BUTTON);
        methods.click(STATE_LOCATOR, state);
        methods.enter(ZIP_CODE_LOCATOR, Constants.map.get("ZIP_CODE"));
        methods.click(COUNTRY_BUTTON);
        methods.enter(BIRTHDAY_LOCATOR, Constants.map.get("BIRTHDAY"));
        methods.enter(COLOR_LOCATOR, Constants.map.get("COLOR"));
        methods.enter(AGE_LOCATOR, Constants.map.get("AGE"));
        methods.enter(WEBSITE_LOCATOR, Constants.map.get("WEBSITE"));
        methods.enter(PICTURE_LOCATOR, Constants.map.get("PICTURE"));
        methods.enter(PHONE_LOCATOR, Constants.map.get("PHONE"));
        methods.click(BUTTON_COMMON_INTERESTS);
        methods.enter(NOTE_LOCATOR, Constants.map.get("NOTE"));
        methods.click(BUTTON_CREATE_ADDRESS);
        methods.click(BUTTON_LIST);

        Assertions.assertTrue(methods.isDisplayed(DISPLAY));

    }

    @Test
    @Order(3)
    @DisplayName("Testing field changes")
    public void testEditAddress() {

        methods.click(BUTTON_EDIT);
        methods.clear(ADDRESS1_LOCATOR);
        methods.enter(ADDRESS1_LOCATOR, Constants.COUNTRY);
        methods.click(BUTTON_CREATE_ADDRESS);

        Assertions.assertEquals(methods.getText(ADDRESS1_NEW_LOCATOR), Constants.COUNTRY,
                "The wrong country was entered or not changed");

    }

    @Test
    @Order(4)
    @DisplayName("Testing for address deletion")
    public void testDeleteAddress() {

        methods.click(BUTTON_LIST);

        List<WebElement> elementsBefore = DRIVER.findElements(TABLE_LOCATOR);
        int elementsTableBefore = elementsBefore.size();

        methods.click(BUTTON_DELETE);
        methods.accept();

        List<WebElement> elementsAfter = DRIVER.findElements(TABLE_LOCATOR);
        int elementsTableAfter = elementsAfter.size();

        Assertions.assertTrue(elementsTableBefore != elementsTableAfter, "The address wasn't deleted");

    }

    @Test
    @Disabled
    @DisplayName("Testing for log out of user")
    public void testLogout() {

        methods.click(BUTTON_SIGN_OUT);

        String urlAfterLogout = DRIVER.getCurrentUrl();
        Assertions.assertEquals(urlAfterLogout, Constants.URL, "The user wasn't logged out");

    }

}