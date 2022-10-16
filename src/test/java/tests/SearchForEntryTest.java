package tests;

import frequentlyusedmethods.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class SearchForEntryTest extends BaseTest {
    @Test
    public void existingEntryIsSearchable() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.clickCreateAnEntryButton();
        entriesPage.waitForTextIsSavedIndicator();
        entriesPage.inputText();
        driverManager.removeTimeout();
        entriesPage.waitForTextIsSavedIndicator();
        entriesPage.clickBackToOverviewButton();

        String entryText = entriesPage.getTextOfTheExistingEntry();
        driverManager.setTimeout();
        entriesPage.inputSearchText();
        entriesPage.clickSearchButton();
        Assert.assertEquals(entriesPage.getTextOfTheExistingEntry(), entryText, "Entry is not found.");
    }
}
