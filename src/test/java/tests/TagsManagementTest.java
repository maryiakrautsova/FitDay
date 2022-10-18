package tests;

import frequentlyusedmethods.LoginSteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class TagsManagementTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(TagsManagementTest.class.getName());

    @Test(priority = 3, description = "this test validates a tag can be added to an entry test")
    public void tagCreationAndAssigmentTest() {
        LoginSteps loginSteps = new LoginSteps();
        LOGGER.info(String.format("Page %s is initialized.", LoginSteps.class.getName()));
        LOGGER.info("User is logged in.");
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        LOGGER.info(String.format("Page %s is initialized.", EntriesPage.class.getName()));
        LOGGER.info("Proceed with the last entry.");
        entriesPage.clickOnTheLastEntry();
        LOGGER.info("Attempt to input a new tag name.");
        entriesPage.inputNewTagName();

        LOGGER.info("Attempt to lick 'OK' button to create a new tag name.");
        entriesPage.clickCreateTagOKButton();
        driverManager.removeTimeout();
        boolean isCreatedTagNameAssignedToEntry = entriesPage.isTagNameAssignedToEntry();

        LOGGER.info("Check whether tag name is assigned to the entry or not.");
        Assert.assertTrue(isCreatedTagNameAssignedToEntry, "Tag is bound incorrectly.");
        driverManager.setTimeout();
    }
}
