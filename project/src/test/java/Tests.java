import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Tests {

    private final WebDriver DRIVER = Driver.getDriver();

    @BeforeAll
    public void setUp() {
        DRIVER.navigate().to("http://a.testaddressbook.com/sign_in");
    }

    @Test
    @DisplayName("Проверка авторизации пользователя")
    public void testLogin() {
        Methods.enter(By.id("session_email"), Constants.EMAIL);
        Methods.enter(By.id("session_password"), Constants.PASSWORD);
        Methods.click(By.cssSelector("input[name='commit']"));
    }

    @Test
    @DisplayName("Проверка добавления адресса")
    public void testAddAddress() {
        Methods.click(By.cssSelector("a[href=\"/addresses\"]"));
        Methods.click(By.cssSelector("a[class= \"row justify-content-center\"]"));
        Methods.enter(By.name("address[first_name]"), Constants.map.get("FIRST_NAME"));
        Methods.enter(By.name("address[last_name]"), Constants.map.get("LAST_NAME"));
        Methods.enter(By.id("address_street_address"), Constants.map.get("ADDRESS1"));
        Methods.enter(By.id("address_secondary_address"), Constants.map.get("ADDRESS2"));
        Methods.enter(By.id("address_city"), Constants.map.get("CITY"));
        Methods.click(By.cssSelector("select[name='address[state]']"));
        Methods.click(By.cssSelector(format("option[value='%s']", State.ALABAMA.getName())));
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
    }

    @Test
    @DisplayName("Проверка изменения данных в полях созданного адресса")
    public void testEditAddress() {
        Methods.click(By.cssSelector("a[data-test='edit']"));
        Methods.clear(By.id("address_street_address"));
        Methods.enter(By.id("address_street_address"), Constants.COUNTRY);
        Methods.click(By.cssSelector("input[class=\"btn btn-primary\"]"));
        Methods.click(By.cssSelector("a[data-test=\"list\"][href=\"/addresses\"]"));
    }

    @Test
    @DisplayName("Проверка удаления адресса")
    public void testDeleteAddress() {
        Methods.click(By.cssSelector("a[data-confirm=\"Are you sure?\"]"));
        DRIVER.switchTo().alert().accept();
    }

    @Test
    @Disabled
    @DisplayName("Проверка выхода из пользователя")
    public void testLogout() {
        Methods.click(By.cssSelector("a[data-test=\"sign-out\"]"));
    }

    @AfterAll
    public void quit() {
        DRIVER.quit();
    }
}