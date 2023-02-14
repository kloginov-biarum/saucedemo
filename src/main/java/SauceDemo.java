import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SauceDemo {

    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/ergrevegvrg/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://www.saucedemo.com/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void loginWithValidaData(){
        WebElement emailInputField = driver.findElement(By.id("user-name"));
        emailInputField.sendKeys("standard_user");
        WebElement passwordInputFiled = driver.findElement(By.id("password"));
        passwordInputFiled.sendKeys("secret_sauce");
        WebElement logInButton = driver.findElement(By.id("login-button"));
        logInButton.click();
        WebElement inventaryList = driver.findElement(By.className("inventory_container"));
        assertTrue("Inventory list is NOT displayed", inventaryList.isDisplayed());
    }



    @After
    public void tearDown(){
        driver.quit();
    }


}
