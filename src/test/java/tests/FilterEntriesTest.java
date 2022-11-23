package tests;

import frequentlyusedmethods.LoginSteps;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EntriesPage;

public class FilterEntriesTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(FilterEntriesTest.class.getName());

    @Test(priority = 3, description = "this test validates entries filtering test")
    public void existingEntriesCanBeFilteredByDateTest() {
        LoginSteps loginSteps = new LoginSteps();
        LOGGER.info(String.format("Page %s is initialized.", LoginSteps.class.getName()));
        LOGGER.info("User is logged in.");
        loginSteps.userLogin(driverManager);

        EntriesPage entriesPage = new EntriesPage(driver);
        LOGGER.info(String.format("Page %s is initialized.", EntriesPage.class.getName()));
        LOGGER.info("Proceed with 'Create An Entry' button.");
        entriesPage.clickCreateAnEntryButton();


        entriesPage = new EntriesPage(driver);
        entriesPage.clickChangeDateOrTimeButton();
        entriesPage.clickToSeeDateOptionsToSelect();
        entriesPage.clickToSelectDay10();
        entriesPage.clickOKButton();

        driverManager.removeTimeout();
        LOGGER.info("Wait for text is saved.");
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();

        entriesPage.clickOnEntryReadyToBeFormatted();

        LOGGER.info("Input text for entry.");
        entriesPage.inputText();
        driverManager.removeTimeout();
        LOGGER.info("Wait for text is saved.");
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();

        LOGGER.info("Proceed with 'Back to Overview' button.");
        entriesPage.clickBackToOverviewButton();

        driverManager.removeTimeout();
        LOGGER.info("Attempt to get date options for filtering field to select.");
        entriesPage.clickSelectDateForFilteringField();

        LOGGER.info("Attempt to select 'day 10'.");
        entriesPage.clickToSelectDay10();

        LOGGER.info("Check entry is filtered correctly.");
        Assert.assertTrue(entriesPage.areAllDaysOfFilteredEntriesEqualTo10(), "Check filtered entries. " +
                "Not all days of filtered entries are equal to 10.");
    }
}
