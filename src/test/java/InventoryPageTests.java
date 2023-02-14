import org.junit.Test;

public class InventoryPageTests extends TestBase{
    public void amountOfProducts(){
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkAllProductsAreDisplayed();
        inventoryPage.checkAmountOfProducts(6);
    }

    public void allElementsAreDisplayed(){
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkTwitterLink();
    }

    @Test
    public void sideBar(){
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnTheSideBarOpenIcon();
        inventoryPage.allItemsIsDisplayed();
        inventoryPage.aboutIsDisplayed();
        inventoryPage.logoutIsDisplayed();
        inventoryPage.resetAppStateIsDisplayed();
    }




}
