package locators;

import org.openqa.selenium.By;

public class PageWithLocators {

    public static final By LOGIN_LOCATOR = By.id("session_email");
    public static final By PASSWORD_LOCATOR = By.id("session_password");
    public static final By SIGN_IN_BUTTON = By.cssSelector("input[name='commit']");
    public static final By PROFILE = By.xpath("//span[@data-test = 'current-user']");
    public static final By BUTTON_ADDRESSES = By.cssSelector("a[href=\"/addresses\"]");
    public static final By BUTTON_NEW_ADDRESS = By.cssSelector("a[class= \"row justify-content-center\"]");
    public static final By FIRST_NAME_LOCATOR = By.name("address[first_name]");
    public static final By LAST_NAME_LOCATOR = By.name("address[last_name]");
    public static final By ADDRESS1_LOCATOR = By.id("address_street_address");
    public static final By ADDRESS2_LOCATOR = By.id("address_secondary_address");
    public static final By CITY_LOCATOR = By.id("address_city");
    public static final By STATE_BUTTON = By.cssSelector("select[name='address[state]']");
    public static final String STATE_LOCATOR = "option[value='%s']";
    public static final By ZIP_CODE_LOCATOR = By.id("address_zip_code");
    public static final By COUNTRY_BUTTON = By.id("address_country_us");
    public static final By BIRTHDAY_LOCATOR = By.id("address_birthday");
    public static final By COLOR_LOCATOR = By.id("address_color");
    public static final By AGE_LOCATOR = By.id("address_age");
    public static final By WEBSITE_LOCATOR = By.id("address_website");
    public static final By PICTURE_LOCATOR = By.id("address_picture");
    public static final By PHONE_LOCATOR = By.id("address_phone");
    public static final By BUTTON_COMMON_INTERESTS = By.cssSelector("input[name=\"address[interest_climb]\"][type=\"checkbox\"]");
    public static final By NOTE_LOCATOR = By.id("address_note");
    public static final By BUTTON_CREATE_ADDRESS = By.cssSelector("input[class=\"btn btn-primary\"]");
    public static final By BUTTON_LIST = By.cssSelector("a[data-test=\"list\"][href=\"/addresses\"]");
    public static final By DISPLAY = By.xpath("//div[@data-test = 'notice']");
    public static final By BUTTON_EDIT = By.xpath("//td/a[contains(@data-test, 'edit')]");
    public static final By ADDRESS1_NEW_LOCATOR = By.xpath("//span[contains(@data-test, 'street_address')]");
    public static final By TABLE_LOCATOR = By.xpath("//tbody/tr");
    public static final By BUTTON_DELETE = By.cssSelector("a[data-confirm=\"Are you sure?\"]");
    public static final By BUTTON_SIGN_OUT = By.cssSelector("a[data-test=\"sign-out\"]");

}
