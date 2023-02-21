import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(className = "cart_item_label")
    private List<WebElement> productCards;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productNames;

    @Step("Checkout button is displayed")
    public boolean checkoutButtonIsDisplayed(){
        return checkoutButton.isDisplayed();
    }

    @Step("Get quantity of products ")
    public boolean checkProductCardsQuantity(int expectedQuantity){
       //assertEquals("Product cards quantity is not equal to "+ expectedQuantity,expectedQuantity,productCards.size());
        return productCards.size() == expectedQuantity;
    }

    @Step("Cart is empty")
    public boolean cartIsEmpty(){
        boolean empty = false;
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(productCards.get(0)));
        } catch (Exception e){
            empty = true;
        }
        return empty;
    }

    @Step("Click on checkout button")
    public void clickOnCheckoutButton(){
        clickOnTheElement(checkoutButton);
    }

}
