import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {


    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage (WebDriver driver){
        super(driver);
    }

    @Step("Filling in username, password and push the Login button")
    public InventoryPage login(User user){
        enterTextToElement(user.getName(), userName);
        enterTextToElement(user.getPassword(), password);
        loginButton.click();
        return new InventoryPage(driver);
    }




}
