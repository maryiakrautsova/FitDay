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
        LOGGER.info("Wait for text is saved.");
        entriesPage.waitForTextIsSavedIndicator();
        LOGGER.info("Input text for entry.");
        entriesPage.inputText();
        driverManager.removeTimeout();
        LOGGER.info("Wait for text is saved.");
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();
        LOGGER.info("Proceed with 'Change Date Or Time' button.");
        entriesPage.clickChangeDateOrTimeButton();
        LOGGER.info("Attempt to make date options to be selected visible.");
        entriesPage.clickToSeeDateOptionsToSelect();
        LOGGER.info("Attempt to select 'day 20'.");
        entriesPage.clickToSelectDay20();
        LOGGER.info("Proceed with 'OK' button.");
        entriesPage.clickOKButton();
        LOGGER.info("Proceed with 'Back to Overview' button.");
        entriesPage.clickBackToOverviewButton();

        LOGGER.info("Proceed with 'Create An Entry' button.");
        entriesPage.clickCreateAnEntryButton();
        entriesPage.waitForTextIsSavedIndicator();
        LOGGER.info("Input text for entry.");
        entriesPage.inputText();
        driverManager.removeTimeout();
        String entryDay5Text = entriesPage.getText().trim();
        entriesPage.waitForTextIsSavedIndicator();
        driverManager.setTimeout();
        LOGGER.info("Proceed with 'Change Date Or Time' button.");
        entriesPage.clickChangeDateOrTimeButton();
        LOGGER.info("Attempt to make date options to be selected visible.");
        entriesPage.clickToSeeDateOptionsToSelect();
        LOGGER.info("Attempt to select 'day 5'.");
        entriesPage.clickToSelectDay5();
        LOGGER.info("Proceed with 'OK' button.");
        entriesPage.clickOKButton();
        LOGGER.info("Proceed with 'Back to Overview' button.");
        entriesPage.clickBackToOverviewButton();

        driverManager.removeTimeout();
        LOGGER.info("Attempt to get date options for filtering field to select.");
        entriesPage.clickSelectDateForFilteringField();
        driverManager.setTimeout();
        LOGGER.info("Attempt to select 'day 5'.");
        entriesPage.clickToSelectDay5();
        driverManager.removeTimeout();
        String filteredEntryText = entriesPage.getTextOfTheExistingEntry();
        driverManager.setTimeout();

        LOGGER.info("Attempt to select 'day 5'.");
        Assert.assertEquals(filteredEntryText, entryDay5Text, "Entry is filtered incorrectly.");
    }
}
