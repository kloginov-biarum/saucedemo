import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public boolean checkoutButtonIsDisplayed(){
        return checkoutButton.isDisplayed();
    }

    public boolean checkProductCardsQuantity(int expectedQuantity){
       //assertEquals("Product cards quantity is not equal to "+ expectedQuantity,expectedQuantity,productCards.size());
        return productCards.size() == expectedQuantity;
    }

    public void clickOnCheckoutButton(){
        clickOnTheElement(checkoutButton);
    }

}
