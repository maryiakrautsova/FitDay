package tests;

import frequentlyusedmethods.LoginSteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import pages.LoginPage;

public class UserLoginTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(UserLoginTest.class.getName());

    @Test(priority = 1, description = "this test validates user can log in into the system test")
    public void existingUserLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s is initialized.", LoginSteps.class.getName()));
        LOGGER.info("Attempt to open login page.");
        loginPage.openLoginPage();
        LOGGER.info("Attempt to fill in 'User' field'.");
        loginPage.fillInUserInputField();
        LOGGER.info("Attempt to fill in 'Password' field'.");
        loginPage.fillInPasswordInputField();
        LOGGER.info("Proceed with 'Login' button.");
        loginPage.clickLoginButton();

        driverManager.removeTimeout();
        LOGGER.info("Attempt to close pop up.");
        loginPage.waitAndCloseModalWindow();
        driverManager.setTimeout();

        EntriesPage entriesPage = new EntriesPage(driver);

        LOGGER.info("Check user is logged in into the system.");
        Assert.assertTrue(entriesPage.isCreateAnEntryButtonVisible(),
                "User can't be logged in into the system.");
    }
}
