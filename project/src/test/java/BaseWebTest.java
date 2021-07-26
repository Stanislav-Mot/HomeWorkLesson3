import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseWebTest {

    protected final WebDriver DRIVER = Driver.getDriver();

    @BeforeAll
    public void setUp() {
        DRIVER.get(Constants.URL);

        String currentURL = DRIVER.getCurrentUrl();
        Assertions.assertEquals("http://a.testaddressbook.com/sign_in", currentURL,
                "The page didn't open or the wrong page");

    }

    @AfterAll
    public void tearDown() {
        DRIVER.quit();
    }
}
