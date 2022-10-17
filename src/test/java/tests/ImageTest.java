package tests;

import frequentlyusedmethods.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import utils.RetryAnalyzer;

public class ImageTest extends BaseTest {
    @Test(priority = 3,
            description = "this test validates adding an image to existing entry test",
            retryAnalyzer = RetryAnalyzer.class)
    public void insertImageToExistingPostTest() {
        LoginSteps loginSteps = new LoginSteps();
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        entriesPage.clickCreateAnEntryButton();
        entriesPage.waitForTextIsSavedIndicator();
        entriesPage.inputText();
        driverManager.removeTimeout();
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();

        entriesPage.clickImageButton();
        entriesPage.switchToChooseFileFrame();
        entriesPage.clickChooseFileButton();
        entriesPage.sendFilePath();
        entriesPage.switchToMainFrame();
        entriesPage.clickImagePropertiesOKButton();
        driverManager.removeTimeout();
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();

        Assert.assertTrue(entriesPage.isImageUploaded(), "Image is not uploaded.");
    }
}
