
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class TestBase {
    public static WebDriver driver;



    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://www.saucedemo.com/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    public  void tearDown()  {
        driver.quit();
    }
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";

    String lockedOutUsername = "locked_out_user";
    String lockedOutPassword = "secret_sauce";

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
            driver.close();
            driver.quit();
        }
        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        @Override
        protected void succeeded(Description description) {
            driver.close();
            driver.quit();
        }
    };



}
