package tests;

import frequentlyusedmethods.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class UserLogoutTest extends BaseTest {

    @Test
    public void existingUserLogoutTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.userLogin(driverManager);
        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.clickLogoutButton();
        entriesPage.waitAndCloseModalWindow();
        Assert.assertFalse(entriesPage.isLogoutButtonPresent(),
                "User is still logged in into the system.");
        driverManager.setTimeout();
    }
}
