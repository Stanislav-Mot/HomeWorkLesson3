import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseWebTest {

    protected WebDriver driver = Driver.getDriver();

    @BeforeAll
    public void setUp() {

        driver.get(Constants.URL);

        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals(Constants.URL, currentURL,
                "The page didn't open or the wrong page");

    }

    @AfterAll
    public void tearDown() {

        driver.quit();
    }
}
