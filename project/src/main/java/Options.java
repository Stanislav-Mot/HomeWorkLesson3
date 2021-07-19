import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class Options {
    private static final String PICTURE = new File("src/main/resources/bmw_x6_promo1.jpg").getAbsolutePath();

    public static void testing() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // first test (Login)
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://a.testaddressbook.com/sign_in");
        driver.findElement(By.id("session_email")).sendKeys("stasmotorin199407@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("qwerty");
        driver.findElement(By.cssSelector("input[name='commit']")).click();

        //second test (add address)
        driver.findElement(By.cssSelector("a[href=\"/addresses\"]")).click();
        driver.findElement(By.cssSelector("a[class= \"row justify-content-center\"]")).click();
        driver.findElement(By.name("address[first_name]")).sendKeys("Stanislav");
        driver.findElement(By.name("address[last_name]")).sendKeys("Motorin");
        driver.findElement(By.id("address_street_address")).sendKeys("Belarus");
        driver.findElement(By.id("address_secondary_address")).sendKeys("Poland");
        driver.findElement(By.id("address_city")).sendKeys("Minsk");
        driver.findElement(By.cssSelector("select[name='address[state]']")).click();
        driver.findElement(By.cssSelector("option[value='MA']")).click();
        driver.findElement(By.id("address_zip_code")).sendKeys("200200");
        driver.findElement(By.id("address_country_us")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("07.10.1994");
        driver.findElement(By.id("address_color")).sendKeys("#FF0000");
        driver.findElement(By.id("address_age")).sendKeys("26");
        driver.findElement(By.id("address_website")).sendKeys("https://senlainc.com/");
        driver.findElement(By.id("address_picture")).sendKeys(PICTURE);
        driver.findElement(By.id("address_phone")).sendKeys("123456789");
        driver.findElement(By.cssSelector("input[name=\"address[interest_climb]\"][type=\"checkbox\"]")).click();
        driver.findElement(By.id("address_note")).sendKeys("are you ok?");
        driver.findElement(By.cssSelector("input[class=\"btn btn-primary\"]")).click();
        driver.findElement(By.cssSelector("a[data-test=\"list\"][href=\"/addresses\"]")).click();

        //third test (edit address)
        driver.findElement(By.cssSelector("a[data-test='edit']")).click();
        driver.findElement(By.id("address_street_address")).clear();
        driver.findElement(By.id("address_street_address")).sendKeys("Germany");
        driver.findElement(By.cssSelector("option[value='CO']")).click();
        driver.findElement(By.id("address_country_canada")).click();
        driver.findElement(By.cssSelector("input[class=\"btn btn-primary\"]")).click();
        driver.findElement(By.cssSelector("a[data-test=\"list\"][href=\"/addresses\"]")).click();

        //fourth test (delete address)
        driver.findElement(By.cssSelector("a[data-confirm=\"Are you sure?\"]")).click();
        driver.switchTo().alert().accept();

        //fifth test (sign out)
        driver.findElement(By.cssSelector("a[data-test=\"sign-out\"]")).click();

        Thread.sleep(5000);

        driver.quit();
    }
}
