package tests;

import frequentlyusedmethods.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class TagsManagementTest extends BaseTest {
    @Test(priority = 3, description = "this test validates a tag can be added to an entry test")
    public void tagCreationAndAssigmentTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.clickOnTheLastEntry();
        entriesPage.clickCreateNewTagField();

        entriesPage.clickCreateTagOKButton();
        driverManager.removeTimeout();
        boolean isCreatedTagNameAssignedToEntry = entriesPage.isTagNameAssignedToEntry();


        Assert.assertTrue(isCreatedTagNameAssignedToEntry, "Tag is bound incorrectly.");
        driverManager.setTimeout();
    }
}
