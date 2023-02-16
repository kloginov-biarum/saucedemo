import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CartPageTests extends TestBase {

    @Test
    public void cartPageIsOpen(){
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnAddToCartBackback();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.checkoutButtonIsDisplayed());
    }

    @Test
    public void addSeveralItems(){
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnAddToCartBackback();
        inventoryPage.clickOnAddToCartBikeLight();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.checkProductCardsQuantity(2));
    }


}
