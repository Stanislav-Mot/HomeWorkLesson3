import org.openqa.selenium.By;

public class Methods {

    public static void enter(By locator, String text) {
        Driver.driver.findElement(locator).sendKeys(text);
    }

    public static void click(By locator) {
        Driver.driver.findElement(locator).click();
    }

    public static void clear(By locator) {
        Driver.driver.findElement(locator).clear();
    }
}
