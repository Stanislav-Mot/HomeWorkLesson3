import org.openqa.selenium.By;

public class Methods {

    public void enter(By locator, String text) {
        Driver.driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        Driver.driver.findElement(locator).click();
    }

    public void click(String locator, State state) {
        Driver.driver.findElement(By.cssSelector(String.format(locator, state.getName()))).click();
    }

    public void clear(By locator) {
        Driver.driver.findElement(locator).clear();
    }

    public void accept() {
        Driver.driver.switchTo().alert().accept();
    }

    public boolean isDisplayed(By selector) {
        return Driver.driver.findElement(selector).isDisplayed();
    }

    public String getText(By selector) {
        return Driver.driver.findElement(selector).getText();
    }

}
