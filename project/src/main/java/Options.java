import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Options {

    private static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver.exe");
        return new ChromeDriver();
    }

    private static final WebDriver DRIVER = getDriver();
    public static final String EMAIL = "stasmotorin199407@gmail.com";
    public static final String PASSWORD = "qwerty";
    public static final String COUNTRY = "Canada";
    private static final String PICTURE = new File("src/main/resources/bmw_x6_promo1.jpg").getAbsolutePath();

    public static Map<String, String> map = new HashMap<String, String>() {
        {
            put("FIRST_NAME", "Stanislav");
            put("LAST_NAME", "Motoryn");
            put("ADDRESS1", "Belarus");
            put("ADDRESS2", "Poland");
            put("CITY", "Minsk");
            put("ZIP_CODE", "200200");
            put("BIRTHDAY", "07.10.1994");
            put("COLOR", "#FF0000");
            put("AGE", "26");
            put("WEBSITE", "https://senlainc.com/");
            put("PICTURE", PICTURE);
            put("PHONE", "123456789");
            put("NOTE", "are you ok?");
        }
    };

    private static void enter(By locator, String text) {
        DRIVER.findElement(locator).sendKeys(text);
    }

    private static void click(By locator) {
        DRIVER.findElement(locator).click();
    }

    private static void clear(By locator) {
        DRIVER.findElement(locator).clear();
    }

    public static void Run() {
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DRIVER.manage().window().maximize();
        DRIVER.get("http://a.testaddressbook.com/sign_in");
    }

    public static void testLogin(String email, String password) {
        enter(By.id("session_email"), email);
        enter(By.id("session_password"), password);
        click(By.cssSelector("input[name='commit']"));
    }

    public static void testAddAddress(Map<String, String> map) {
        click(By.cssSelector("a[href=\"/addresses\"]"));
        click(By.cssSelector("a[class= \"row justify-content-center\"]"));
        enter(By.name("address[first_name]"), map.get("FIRST_NAME"));
        enter(By.name("address[last_name]"), map.get("LAST_NAME"));
        enter(By.id("address_street_address"), map.get("ADDRESS1"));
        enter(By.id("address_secondary_address"), map.get("ADDRESS2"));
        enter(By.id("address_city"), map.get("CITY"));
        click(By.cssSelector("select[name='address[state]']"));
        click(By.cssSelector(String.format("option[value='%s']", State.ALABAMA.getName())));
        enter(By.id("address_zip_code"), map.get("ZIP_CODE"));
        click(By.id("address_country_us"));
        enter(By.id("address_birthday"), map.get("BIRTHDAY"));
        enter(By.id("address_color"), map.get("COLOR"));
        enter(By.id("address_age"), map.get("AGE"));
        enter(By.id("address_website"), map.get("WEBSITE"));
        enter(By.id("address_picture"), map.get("PICTURE"));
        enter(By.id("address_phone"), map.get("PHONE"));
        click(By.cssSelector("input[name=\"address[interest_climb]\"][type=\"checkbox\"]"));
        enter(By.id("address_note"), map.get("NOTE"));
        click(By.cssSelector("input[class=\"btn btn-primary\"]"));
        click(By.cssSelector("a[data-test=\"list\"][href=\"/addresses\"]"));
    }

    public static void testEditAddress(String country) {
        click(By.cssSelector("a[data-test='edit']"));
        clear(By.id("address_street_address"));
        enter(By.id("address_street_address"), country);
        click(By.cssSelector("input[class=\"btn btn-primary\"]"));
        click(By.cssSelector("a[data-test=\"list\"][href=\"/addresses\"]"));
    }

    public static void testDeleteAddress() {
        click(By.cssSelector("a[data-confirm=\"Are you sure?\"]"));
        DRIVER.switchTo().alert().accept();
    }

    public static void testLogout() {
        click(By.cssSelector("a[data-test=\"sign-out\"]"));
    }

    public static void quit() {
        DRIVER.quit();
    }
}
