import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseWebTest {

    protected WebDriver DRIVER = Driver.getDriver();

    @BeforeAll
    public void setUp() {

        Log.info("Open the login and password page");
        DRIVER.get(Constants.URL);

        Log.info("Checking that the correct page has opened");
        String currentURL = DRIVER.getCurrentUrl();
        Assertions.assertEquals(Constants.URL, currentURL,
                "The page didn't open or the wrong page");

    }

    @AfterAll
    public void tearDown() {

        Log.info("Exiting the driver");
        DRIVER.quit();
    }
}
