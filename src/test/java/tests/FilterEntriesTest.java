package tests;

import frequentlyusedmethods.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class FilterEntriesTest extends BaseTest {
    @Test(priority = 3, description = "this test validates entries filtering test")
    public void existingEntriesCanBeFilteredByDateTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.clickCreateAnEntryButton();
        entriesPage.waitForTextIsSavedIndicator();
        entriesPage.inputText();
        driverManager.removeTimeout();
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();
        entriesPage.clickChangeDateOrTimeButton();
        entriesPage.clickToSeeDateOptionsToSelect();
        entriesPage.clickToSelectDay20();
        entriesPage.clickOKButton();
        entriesPage.clickBackToOverviewButton();

        entriesPage.clickCreateAnEntryButton();
        entriesPage.waitForTextIsSavedIndicator();
        entriesPage.inputText();
        driverManager.removeTimeout();
        String entryDay5Text = entriesPage.getText().trim();
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();
        entriesPage.clickChangeDateOrTimeButton();
        entriesPage.clickToSeeDateOptionsToSelect();
        entriesPage.clickToSelectDay5();
        entriesPage.clickOKButton();
        entriesPage.clickBackToOverviewButton();

        driverManager.removeTimeout();
        entriesPage.clickSelectDateForFilteringField();
        driverManager.setTimeout();
        entriesPage.clickToSelectDay5();
        driverManager.removeTimeout();
        String filteredEntryText = entriesPage.getTextOfTheExistingEntry();
        driverManager.setTimeout();

        Assert.assertEquals(filteredEntryText, entryDay5Text, "Entry is filtered incorrectly.");
    }
}
