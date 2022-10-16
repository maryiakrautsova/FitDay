package tests;

import frequentlyusedmethods.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class EntryCreationTest extends BaseTest {
    @Test
    public void newEntryCreationTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.userLogin(driverManager);
        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.clickCreateAnEntryButton();
        entriesPage.waitForTextIsSavedIndicator();
        entriesPage.inputText();
        driverManager.removeTimeout();
        entriesPage.waitForTextIsSavedIndicator();
        String actualInputText = entriesPage.getTextOfEntryReadyToBeFormatted().trim();
        driverManager.setTimeout();
        Assert.assertEquals(
                actualInputText,
                entriesPage.getText().trim(),
                "Entry hasn't been created correctly.");
    }
}
