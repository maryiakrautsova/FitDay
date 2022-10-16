package tests;

import frequentlyusedmethods.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class EntryRemovalTest extends BaseTest {
    @Test
    public void existingEntryCanBeRemovedTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.clickCreateAnEntryButton();
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();
        entriesPage.inputText();
        driverManager.removeTimeout();
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();
        entriesPage.clickBackToOverviewButton();

        driverManager.removeTimeout();
        String entryCreationDateAndTime = entriesPage.getDateLastEntryWasCreatedOrUpdated();
        driverManager.setTimeout();
        entriesPage.tickLastEntryCheckbox();
        entriesPage.clickDeleteSelectedEntriesButton();
        entriesPage.confirmDeletionOfSelectedEntries();
        driverManager.removeTimeout();
        String lastEntryCreationDateAndTime = entriesPage.getDateLastEntryWasCreatedOrUpdated();
        driverManager.setTimeout();
        Assert.assertNotEquals(lastEntryCreationDateAndTime, entryCreationDateAndTime, "Entry is not deleted.");
    }
}
