import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class CheckoutTests extends TestBase{

    @Test
    public void checkQuantityOfProducts(){
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnAddToCartBackback();
        inventoryPage.clickOnAddToCartBikeLight();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterFirstName("Harry");
        checkoutStepOnePage.enterLastName("Belly");
        checkoutStepOnePage.enterZipCode("12345");
        checkoutStepOnePage.pushContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        assertTrue(checkoutStepTwoPage.checkProductCardsQuantity(2));
        assertThat(checkoutStepTwoPage.getProductCards(), hasSize(2));

    }

}
