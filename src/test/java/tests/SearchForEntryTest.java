package tests;

import frequentlyusedmethods.LoginSteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class SearchForEntryTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(SearchForEntryTest.class.getName());

    @Test(priority = 3, description = "this test validates an entry is searchable test")
    public void existingEntryIsSearchable() {
        LoginSteps loginSteps = new LoginSteps();
        LOGGER.info(String.format("Page %s is initialized.", LoginSteps.class.getName()));
        LOGGER.info("User is logged in.");
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        LOGGER.info(String.format("Page %s is initialized.", EntriesPage.class.getName()));
        LOGGER.info("Proceed with 'Create An Entry' button.");
        entriesPage.clickCreateAnEntryButton();
        LOGGER.info("Wait for text is saved.");
        entriesPage.waitForTextIsSavedIndicator();
        LOGGER.info("Input text for entry.");
        entriesPage.inputText();
        driverManager.removeTimeout();
        LOGGER.info("Wait for text is saved.");
        entriesPage.waitForTextIsSavedIndicator();
        LOGGER.info("Proceed with 'Back To Overview' button.");
        entriesPage.clickBackToOverviewButton();

        String entryText = entriesPage.getTextOfTheExistingEntry();
        driverManager.setTimeout();
        LOGGER.info("Proceed with search text input.");
        entriesPage.inputSearchText();
        LOGGER.info("Proceed with 'Search' button.");
        entriesPage.clickSearchButton();
        LOGGER.info("Check the entry is found.");
        Assert.assertEquals(entriesPage.getTextOfTheExistingEntry(), entryText, "Entry is not found.");
    }
}
