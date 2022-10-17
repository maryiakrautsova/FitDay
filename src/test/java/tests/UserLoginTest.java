package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import pages.LoginPage;

public class UserLoginTest extends BaseTest {
    @Test(priority = 1, description = "this test validates user can log in into the system test")
    public void existingUserLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.fillInUserInputField();
        loginPage.fillInPasswordInputField();
        loginPage.clickLoginButton();

        driverManager.removeTimeout();
        loginPage.waitAndCloseModalWindow();
        driverManager.setTimeout();

        EntriesPage entriesPage = new EntriesPage(driver);

        Assert.assertTrue(entriesPage.isCreateAnEntryButtonVisible(),
                "User can't be logged in into the system.");
    }
}
