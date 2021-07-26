import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(JUnitPlatform.class)
@SelectClasses(BaseWebTest.class)
public class Tests extends BaseWebTest {

    @Test
    @Order(1)
    @DisplayName("Testing for authorization of user")
    public void testLogin() {
        Methods.enter(By.id("session_email"), Constants.EMAIL);
        Methods.enter(By.id("session_password"), Constants.PASSWORD);
        Methods.click(By.cssSelector("input[name='commit']"));

        String userEmail = DRIVER.findElement(By.xpath("//span[@data-test = 'current-user']")).getText();
        Assertions.assertEquals(userEmail, Constants.EMAIL, "The user wasn't found or the wrong user");

    }

    @ParameterizedTest
    @EnumSource(State.class)
    @Order(2)
    @DisplayName("Testing for adding an address")
    public void testAddAddress(State state) {
        Methods.click(By.cssSelector("a[href=\"/addresses\"]"));
        Methods.click(By.cssSelector("a[class= \"row justify-content-center\"]"));
        Methods.enter(By.name("address[first_name]"), Constants.map.get("FIRST_NAME"));
        Methods.enter(By.name("address[last_name]"), Constants.map.get("LAST_NAME"));
        Methods.enter(By.id("address_street_address"), Constants.map.get("ADDRESS1"));
        Methods.enter(By.id("address_secondary_address"), Constants.map.get("ADDRESS2"));
        Methods.enter(By.id("address_city"), Constants.map.get("CITY"));
        Methods.click(By.cssSelector("select[name='address[state]']"));
        Methods.click(By.cssSelector(format("option[value='%s']", state.getName())));
        Methods.enter(By.id("address_zip_code"), Constants.map.get("ZIP_CODE"));
        Methods.click(By.id("address_country_us"));
        Methods.enter(By.id("address_birthday"), Constants.map.get("BIRTHDAY"));
        Methods.enter(By.id("address_color"), Constants.map.get("COLOR"));
        Methods.enter(By.id("address_age"), Constants.map.get("AGE"));
        Methods.enter(By.id("address_website"), Constants.map.get("WEBSITE"));
        Methods.enter(By.id("address_picture"), Constants.map.get("PICTURE"));
        Methods.enter(By.id("address_phone"), Constants.map.get("PHONE"));
        Methods.click(By.cssSelector("input[name=\"address[interest_climb]\"][type=\"checkbox\"]"));
        Methods.enter(By.id("address_note"), Constants.map.get("NOTE"));
        Methods.click(By.cssSelector("input[class=\"btn btn-primary\"]"));
        Methods.click(By.cssSelector("a[data-test=\"list\"][href=\"/addresses\"]"));

        Assertions.assertTrue(DRIVER.findElement(By.xpath("//div[@data-test = 'notice']")).isDisplayed());

    }

    @Test
    @Order(3)
    @DisplayName("Testing field changes")
    public void testEditAddress() {
        Methods.click(By.xpath("//td/a[contains(@data-test, 'edit')]"));
        Methods.clear(By.id("address_street_address"));
        Methods.enter(By.id("address_street_address"), Constants.COUNTRY);
        Methods.click(By.cssSelector("input[class=\"btn btn-primary\"]"));

        String fieldCountryFirst = DRIVER.findElement(By.xpath("//span[contains(@data-test, 'street_address')]")).getText();
        Assertions.assertEquals(fieldCountryFirst, Constants.COUNTRY, "The wrong country was entered or not changed");

        Methods.click(By.cssSelector("a[data-test=\"list\"][href=\"/addresses\"]"));

    }

    @Test
    @Order(4)
    @DisplayName("Testing for address deletion")
    public void testDeleteAddress() {

        List<WebElement> elementsBefore = DRIVER.findElements(By.xpath("//tbody/tr"));
        int elementsTableBefore = elementsBefore.size();

        Methods.click(By.cssSelector("a[data-confirm=\"Are you sure?\"]"));
        DRIVER.switchTo().alert().accept();

        List<WebElement> elementsAfter = DRIVER.findElements(By.xpath("//tbody/tr"));
        int elementsTableAfter = elementsAfter.size();

        Assertions.assertTrue(elementsTableBefore != elementsTableAfter, "The address wasn't deleted");

    }

    @Test
    @Disabled
    @DisplayName("Testing for log out of user")
    public void testLogout() {
        Methods.click(By.cssSelector("a[data-test=\"sign-out\"]"));

        String urlAfterLogout = DRIVER.getCurrentUrl();
        Assertions.assertTrue(urlAfterLogout.equals(Constants.URL), "The user wasn't logged out");

    }

}