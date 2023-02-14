import io.qameta.allure.Attachment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LoginPageTests extends TestBase{





    @Test
    public void loginWithValidData(){
        User user = new User(validUsername, validPassword);
        new LoginPage(driver).login(user).inventoryListShouldBeDisplayed();
    }

    @Test
    public void loginLockedOutUser(){
        User lockedOutUser = new User(lockedOutUsername, lockedOutPassword);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(lockedOutUser);
    }



}
