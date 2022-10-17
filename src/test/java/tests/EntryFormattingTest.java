package tests;

import frequentlyusedmethods.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class EntryFormattingTest extends BaseTest {
    @Test(priority = 2, description = "this test validates an entry text formatting test")
    public void fontFormattingTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        String textEntry = entriesPage.getTextOfLastEntry();
        driverManager.removeTimeout();
        entriesPage.clickOnTheLastEntry();


        driverManager.setTimeout();

        entriesPage.selectTextOfEntry();
        entriesPage.clickBoldButton();
        driverManager.removeTimeout();
        entriesPage.waitForTextIsSavedIndicator();

        String actualInputText = entriesPage.getEntryBoldText();
        driverManager.setTimeout();
        Assert.assertEquals(actualInputText,
                textEntry,
                "Tex entry's type is not bold.");
    }
}
