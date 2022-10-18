package tests;

import frequentlyusedmethods.LoginSteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class UserLogoutTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(UserLogoutTest.class.getName());

    @Test(priority = 1, description = "this test validates user can log out of the system test")
    public void existingUserLogoutTest() {
        LoginSteps loginSteps = new LoginSteps();
        LOGGER.info(String.format("Page %s is initialized.", LoginSteps.class.getName()));
        LOGGER.info("User is logged in.");
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        LOGGER.info(String.format("Page %s is initialized.", EntriesPage.class.getName()));
        LOGGER.info("Proceed with 'Logout' button.");
        entriesPage.clickLogoutButton();
        LOGGER.info("Proceed with closing pop up.");
        entriesPage.waitAndCloseModalWindow();

        LOGGER.info("Check user is logged out.");
        Assert.assertFalse(entriesPage.isLogoutButtonPresent(),
                "User is still logged in into the system.");
        driverManager.setTimeout();
    }
}
