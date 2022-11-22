package tests;

import frequentlyusedmethods.LoginSteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import utils.RetryAnalyzer;

public class EntryCreationTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(EntryCreationTest.class.getName());

    @Test(priority = 1,
            description = "this test validates a new entry creation test",
            retryAnalyzer = RetryAnalyzer.class)
    public void newEntryCreationTest() {
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
        String expectedTextEntry = entriesPage.getText().trim();
        driverManager.removeTimeout();
        LOGGER.info("Wait for text is saved.");
        entriesPage.waitForTextIsSavedIndicator();

        entriesPage = new EntriesPage(driver);
        String actualInputText = entriesPage.getTextOfEntryReadyToBeFormatted().trim();
        driverManager.setTimeout();
        LOGGER.info("Check entry is created and saved.");
        Assert.assertEquals(
                actualInputText,
                expectedTextEntry,
                "Entry is created incorrectly.");
    }
}
