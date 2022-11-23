package tests;

import frequentlyusedmethods.LoginSteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class EntryFormattingTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(EntryFormattingTest.class.getName());

    @Test(priority = 2, description = "this test validates an entry text formatting test")
    public void fontFormattingTest() {
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

        LOGGER.debug("Proceed with clicking 'Back To Overview' button.");
        entriesPage.clickBackToOverviewButton();

        LOGGER.info(String.format("Page %s is initialized.", EntriesPage.class.getName()));
        LOGGER.info("Proceed with getting text of the last entry.");
        String textEntry = entriesPage.getTextOfLastEntry().trim();
        driverManager.removeTimeout();
        LOGGER.info("Attempt to click on the last entry.");
        entriesPage.clickOnTheLastEntry();


        driverManager.setTimeout();

        LOGGER.info("Attempt to select text of the entry.");
        entriesPage.selectTextOfEntry();
        LOGGER.info("Attempt to click 'Bold' button.");
        entriesPage.clickBoldButton();
        driverManager.removeTimeout();
        entriesPage.waitForTextIsSavedIndicator();

        String actualInputText = entriesPage.getEntryBoldText().trim();
        driverManager.setTimeout();
        LOGGER.info("Check whether text is bold or not.");
        Assert.assertEquals(actualInputText,
                textEntry,
                "Tex entry's type is not bold.");
    }
}
