
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.hamcrest.Matchers.*;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


public class InventoryPage extends BasePage{


    @FindBy(id = "inventory_container")
    private WebElement inventaryList;

    @FindBy(css = "[class='inventory_item']")
    private List<WebElement> productCards;

    @FindBy(xpath = "//a[@href='https://twitter.com/saucelabs']")
    private WebElement twitterIconLink;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sideBarOpenIcon;

    @FindBy (id = "inventory_sidebar_link")
    private WebElement allItems;

    @FindBy (id = "about_sidebar_link")
    private WebElement about;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppState;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement closeSideBarIcon;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLightToCartButton;

    public InventoryPage(WebDriver driver) {
     super(driver);
    }


    public void inventoryListShouldBeDisplayed(){
        assertFalse("Element " + "inventaryList" + "is NOT visible",inventaryList.isDisplayed());
    }

    public void checkAllProductsAreDisplayed(){
        for (WebElement product: productCards) {
            assertTrue(product.isDisplayed());
        }
    }
    public void checkAmountOfProducts(int expectedAmount){
        assertEquals("Amount of products is not " + expectedAmount ,productCards.size(),expectedAmount);
    }

    public void checkProductNameIsDisplayed(){

    }

    public void checkProductNameIsNotEmpty(){

    }

    public void checkTwitterLink(){
        assertTrue(twitterIconLink.isDisplayed());
    }


    public void clickOnTheSideBarOpenIcon(){
        clickOnTheElement(sideBarOpenIcon);
    }

    public void allItemsIsDisplayed(){
        assertTrue(allItems.isDisplayed());
    }
    public void aboutIsDisplayed(){
       // assertTrue(about.isDisplayed());
        assertThat(about.isDisplayed(),is(true));
       // assertThat(about.getAttribute("href"), startsWith("https://"));
       // assertThat(about.getText(),allOf(startsWith("https://"),containsString("saucedemo")));
    }

    public void logoutIsDisplayed(){
        assertTrue(logout.isDisplayed());


    }
    public void resetAppStateIsDisplayed(){
        //assertTrue(resetAppState.isDisplayed());
    }

    public void clickOnAddToCartBackback(){
        clickOnTheElement(addBackpackToCartButton);
    }

    public void clickOnAddToCartBikeLight(){
        clickOnTheElement(addBikeLightToCartButton);
    }

    public void clickOnTheCartIcon(){
        clickOnTheElement(cartIcon);
    }

    public void clickOnTheResetAppState(){
        clickOnTheElement(resetAppState);
    }

    public void clickOnTheCloseSideBArIcon(){
        clickOnTheElement(closeSideBarIcon);
    }

    public void resetAppState(){
       clickOnTheSideBarOpenIcon();
       clickOnTheResetAppState();
       clickOnTheCloseSideBArIcon();
       refreshPage();
    }


}
