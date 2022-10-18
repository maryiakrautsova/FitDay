package tests;

import frequentlyusedmethods.LoginSteps;
import io.qameta.allure.Attachment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class EntryRemovalTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(EntryRemovalTest.class.getName());
    @Test(priority = 1, description = "this test validates an existing entry removal test")
    @Attachment(value = "screenshot", type = "image/png")
    public void existingEntryCanBeRemovedTest() {
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
        driverManager.setTimeout();
        LOGGER.info("Input text for entry.");
        entriesPage.inputText();
        driverManager.removeTimeout();
        LOGGER.info("Wait for text is saved.");
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();
        entriesPage.clickBackToOverviewButton();

        driverManager.removeTimeout();
        String entryCreationDateAndTime = entriesPage.getDateLastEntryWasCreatedOrUpdatedOn();
        driverManager.setTimeout();
        entriesPage.tickLastEntryCheckbox();
        entriesPage.clickDeleteSelectedEntriesButton();
        entriesPage.confirmDeletionOfSelectedEntries();
        driverManager.removeTimeout();
        String lastEntryCreationDateAndTime = entriesPage.getDateLastEntryWasCreatedOrUpdatedOn();
        driverManager.setTimeout();
        LOGGER.info("Check whether entry is deleted or not.");
        Assert.assertNotEquals(lastEntryCreationDateAndTime, entryCreationDateAndTime, "Entry is not deleted.");
    }
}
