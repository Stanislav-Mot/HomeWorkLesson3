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

        Log.info("Entered EMAIL");
        methods.enter(LOGIN_LOCATOR, Constants.EMAIL);

        Log.info("Entered password");
        methods.enter(PASSWORD_LOCATOR, Constants.PASSWORD);

        Log.info("The sign_in button is clicked");
        methods.click(SIGN_IN_BUTTON);

        Log.info("Checking the user's compliance");
        Assertions.assertEquals(methods.getText(PROFILE), Constants.EMAIL,
                "The user wasn't found or the wrong user");

    }

    @ParameterizedTest
    @EnumSource(State.class)
    @Order(2)
    @DisplayName("Testing for adding an address")
    public void testAddAddress(State state) {

        Log.info("The addresses button is clicked");
        methods.click(BUTTON_ADDRESSES);

        Log.info("The new_address button is clicked");
        methods.click(BUTTON_NEW_ADDRESS);

        Log.info("Filling in the first_name field");
        methods.enter(FIRST_NAME_LOCATOR, Constants.map.get("FIRST_NAME"));

        Log.info("Filling in the last_name field");
        methods.enter(LAST_NAME_LOCATOR, Constants.map.get("LAST_NAME"));

        Log.info("Filling in the address_1 field");
        methods.enter(ADDRESS1_LOCATOR, Constants.map.get("ADDRESS1"));

        Log.info("Filling in the address_2 field");
        methods.enter(ADDRESS2_LOCATOR, Constants.map.get("ADDRESS2"));

        Log.info("Filling in the city field");
        methods.enter(CITY_LOCATOR, Constants.map.get("CITY"));

        Log.info("The state button is clicked");
        methods.click(STATE_BUTTON);

        Log.info("Choosing a state");
        methods.click(STATE_LOCATOR, state);

        Log.info("Filling in the zip_code field");
        methods.enter(ZIP_CODE_LOCATOR, Constants.map.get("ZIP_CODE"));

        Log.info("The country button is clicked");
        methods.click(COUNTRY_BUTTON);

        Log.info("Filling in the birthday field");
        methods.enter(BIRTHDAY_LOCATOR, Constants.map.get("BIRTHDAY"));

        Log.info("Filling in the color field");
        methods.enter(COLOR_LOCATOR, Constants.map.get("COLOR"));

        Log.info("Filling in the age field");
        methods.enter(AGE_LOCATOR, Constants.map.get("AGE"));

        Log.info("Filling in the website field");
        methods.enter(WEBSITE_LOCATOR, Constants.map.get("WEBSITE"));

        Log.info("The picture is put in");
        methods.enter(PICTURE_LOCATOR, Constants.map.get("PICTURE"));

        Log.info("Filling in the phone field");
        methods.enter(PHONE_LOCATOR, Constants.map.get("PHONE"));

        Log.info("The common_interests button is clicked");
        methods.click(BUTTON_COMMON_INTERESTS);

        Log.info("Filling in the note field");
        methods.enter(NOTE_LOCATOR, Constants.map.get("NOTE"));

        Log.info("The create_address button is clicked");
        methods.click(BUTTON_CREATE_ADDRESS);

        Log.info("The list button is clicked");
        methods.click(BUTTON_LIST);

        Log.info("Checking the label");
        Assertions.assertTrue(methods.isDisplayed(DISPLAY));

    }

    @Test
    @Order(3)
    @DisplayName("Testing field changes")
    public void testEditAddress() {

        Log.info("The edit button is clicked");
        methods.click(BUTTON_EDIT);

        Log.info("Clearing the address_1 field");
        methods.clear(ADDRESS1_LOCATOR);

        Log.info("Changing the address_1 field");
        methods.enter(ADDRESS1_LOCATOR, Constants.COUNTRY);

        Log.info("The update_address button is clicked");
        methods.click(BUTTON_CREATE_ADDRESS);

        Log.info("Checking that the country has changed");
        Assertions.assertEquals(methods.getText(ADDRESS1_NEW_LOCATOR), Constants.COUNTRY,
                "The wrong country was entered or not changed");

    }

    @Test
    @Order(4)
    @DisplayName("Testing for address deletion")
    public void testDeleteAddress() {

        Log.info("The list button is clicked");
        methods.click(BUTTON_LIST);

        Log.info("Getting the number of addresses");
        List<WebElement> elementsBefore = DRIVER.findElements(TABLE_LOCATOR);
        int elementsTableBefore = elementsBefore.size();

        Log.info("The delete button is clicked");
        methods.click(BUTTON_DELETE);

        Log.info("The 'ok' button is clicked");
        methods.accept();

        Log.info("Getting the number of addresses");
        List<WebElement> elementsAfter = DRIVER.findElements(TABLE_LOCATOR);
        int elementsTableAfter = elementsAfter.size();

        Log.info("Checking that the address has been deleted");
        Assertions.assertTrue(elementsTableBefore != elementsTableAfter, "The address wasn't deleted");

    }

    @Test
    @Disabled
    @DisplayName("Testing for log out of user")
    public void testLogout() {

        Log.info("The sign_out button is clicked");
        methods.click(BUTTON_SIGN_OUT);

        Log.info("Checking that the user is sign out");
        String urlAfterLogout = DRIVER.getCurrentUrl();
        Assertions.assertEquals(urlAfterLogout, Constants.URL, "The user wasn't logged out");

    }

}