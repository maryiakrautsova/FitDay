package tests;

import frequentlyusedmethods.LoginSteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;
import utils.RetryAnalyzer;

public class ImageTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(ImageTest.class.getName());

    @Test(priority = 3,
            description = "this test validates adding an image to existing entry test",
            retryAnalyzer = RetryAnalyzer.class)
    public void insertImageToExistingPostTest() {
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
        driverManager.setTimeout();

        LOGGER.info("Proceed with 'Image' button.");
        entriesPage.clickImageButton();
        LOGGER.info("Attempt to switch to 'Choose File' frame.");
        entriesPage.switchToChooseFileFrame();
        LOGGER.info("Proceed with 'Choose File' button.");
        entriesPage.clickChooseFileButton();
        LOGGER.info("Attempt to send path os the image ready to be selected.");
        entriesPage.sendFilePath();
        LOGGER.info("Attempt to switch to main/parent frame.");
        entriesPage.switchToMainFrame();
        LOGGER.info("Proceed with 'OK' button.");
        entriesPage.clickImagePropertiesOKButton();
        driverManager.removeTimeout();
        LOGGER.info("Wait for text is saved.");
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();

        LOGGER.info("Check whether image is uploaded or not.");
        Assert.assertTrue(entriesPage.isImageUploaded(), "Image is not uploaded.");
    }
}
