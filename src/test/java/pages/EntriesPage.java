package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakeMessageGenerator;

import java.util.List;


public class EntriesPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(EntriesPage.class.getName());
    String text = FakeMessageGenerator.generateTextEntry();
    String tag = FakeMessageGenerator.generateTag();

    public String getText() {
        return text;
    }

    @FindBy(id = "create-entry")
    private WebElement createAnEntryButton;

    @FindBy(xpath = "//button[contains(@class, 'user-menu-btn')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@custom-contenteditable, 'custom-contenteditable')]")
    private WebElement inputTextField;

    @FindBy(id = "back-to-overview")
    private WebElement backToOverviewButton;

    @FindBy(xpath = "(//a[contains(@class, 'entry')])[1]//div[contains(@class, 'body')]")
    private WebElement textAreaOfTheExistingEntry;

    @FindBy(xpath = "(//div[contains(@class, 'body ')])[1]")
    private WebElement filteredEntryTextArea;

    @FindBy(xpath = "(//p)[1]")
    private WebElement entryReadyToBeFormatted;

    @FindBy(xpath = "(//div[contains(@class, 'body')])[1]")
    private WebElement lastEntry;

    @FindBy(xpath = "//span[text()='saved']")
    private WebElement savedIndicator;

    @FindBy(xpath = "//div[text()='Log out']")
    private WebElement cancelModalWindowButton;

    @FindBy(xpath = "(//input[contains(@ng-change, 'updateSelectionState()')])[1]")
    private WebElement lastEntryCheckbox;

    @FindBy(id = "delete-entries")
    private WebElement deleteSelectedEntriesButton;

    @FindBy(xpath = "(//div[contains(@class, 'day ng-binding')])[1]")
    private WebElement dayLastEntryWasCreatedOrUpdatedOn;

    @FindBy(xpath = "(//div[contains(@class, 'month ng-binding')])[1]")
    private WebElement monthLastEntryWasCreatedOrUpdatedOn;

    @FindBy(xpath = "(//div[contains(@class, 'time ng-binding')])[1]")
    private WebElement timeLastEntryWasCreatedOrUpdatedOn;

    @FindBy(id = "appendedInputButton")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@title, 'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(@class,'link_text_long')]")
    private WebElement changeDateOrTimeButton;

    @FindBy(id = "date")
    private WebElement dateOptions;

    @FindBy(css = ".entry-container .calendar-date :nth-child(1)")
    private List<WebElement> daysOfAllFilteredEntries;

    @FindBy(xpath = "(//td[text()='10'])[1]")
    private WebElement day10;

    @FindBy(xpath = "//button[contains(@ng-click, 'changeDate()')]")
    private WebElement changeDateOKButton;

    @FindBy(id = "datepicker")
    private WebElement selectDateForFilteringField;

    @FindBy(id = "new-tag")
    private WebElement createNewTagField;

    @FindBy(xpath = "(//div[contains(@class, 'btn-text-content')])[2]")
    private WebElement createTagOKButton;

    @FindBy(css = ".assigned-tags span a")
    private List<WebElement> allAssignedTags;

    @FindBy(xpath = "(//a[contains(@title, 'Image')])[1]")
    private WebElement imageButton;

    @FindBy(xpath = "//iframe[@title='Upload']")
    private WebElement chooseFileFrame;

    @FindBy(xpath = "//input[@name='txtUpload']")
    private WebElement chooseFileButton;

    @FindBy(xpath = "//span[text()='OK']")
    private WebElement imagePropertiesOKButton;

    @FindBy(xpath = "//img[contains(@data-widget,'image')]")
    private WebElement uploadedImage;

    @FindBy(xpath = "//a[contains(@title, 'Bold (⌘+B)')]")
    private WebElement boldButton;

    @FindBy(css = "p > strong")
    private WebElement textInBold;

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCreateAnEntryButtonVisible() {
        LOGGER.debug(String.format("Check whether 'Create An Entry Button' - %s - is visible or not.",
                createAnEntryButton));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        try {
            wait.until(ExpectedConditions.visibilityOf(createAnEntryButton));
        } catch (WebDriverException e) {
            return false;
        }
        return true;
    }

    public void clickCreateAnEntryButton() {
        LOGGER.debug(String.format("Attempt to click 'Create An Entry' button: %s.", createAnEntryButton));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.
                visibilityOf(createAnEntryButton));
        createAnEntryButton.click();
    }

    public void clickLogoutButton() {
        LOGGER.debug(String.format("Attempt to click 'Logout' button: %s.", logoutButton));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.
                visibilityOf(logoutButton));
        logoutButton.click();
    }

    public boolean isLogoutButtonPresent() {
        LOGGER.debug(String.format("Check presence of 'Logout' button: %s.", logoutButton));
        return logoutButton.isDisplayed();
    }

    public void waitAndCloseModalWindow() {
        LOGGER.debug(String.format("Wait and close modal window in case it pops up: %s", cancelModalWindowButton));
        WebDriverWait wait = new WebDriverWait(driver, 50);

        try {
            wait.until(ExpectedConditions.
                    visibilityOf(cancelModalWindowButton));
            cancelModalWindowButton.click();
        } catch (Throwable e) {

        }
    }

    public void inputText() {
        LOGGER.debug(String.format("Attempt to send text for a new entry: %s", text));
        inputTextField.sendKeys(text);
    }

    public void clickBackToOverviewButton() {
        LOGGER.debug(String.format("Attempt to click on 'Back To Overview' button: %s", backToOverviewButton));
        backToOverviewButton.click();
    }

    public String getTextOfTheExistingEntry() {
        LOGGER.debug(String.format("Attempt to get text of an existing entry: %s", textAreaOfTheExistingEntry));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@class, 'entry')])[1]//div[contains(@class, 'body')]")));
        return textAreaOfTheExistingEntry.getText();
    }

    public String getTextOfFilteredEntry() {
        LOGGER.debug(String.format("Attempt to get text of the filtered entry: %s", filteredEntryTextArea));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@ng-class, 'searchParameterClass')]")));
        return filteredEntryTextArea.getText();
    }

    public void waitForTextIsSavedIndicator() {
        LOGGER.debug(String.format("Wait for text input for an entry is saved: %s", savedIndicator));
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='saved']")));
    }

    public void tickLastEntryCheckbox() {
        LOGGER.debug(String.format("Attempt to select the last entry (checkbox): %s", lastEntryCheckbox));
        lastEntryCheckbox.click();
    }

    public void clickDeleteSelectedEntriesButton() {
        LOGGER.debug(String.format("Attempt to click on 'Delete Selected Entries' button: %s",
                deleteSelectedEntriesButton));
        deleteSelectedEntriesButton.click();
    }

    public void confirmDeletionOfSelectedEntries() {
        LOGGER.debug("Attempt to confirm selected entry removal.");
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getTextOfEntryReadyToBeFormatted() {
        LOGGER.debug(String.format("Attempt to get text of entry which is ready for formatting: %s",
                entryReadyToBeFormatted));
        return entryReadyToBeFormatted.getText();
    }

    public void clickOnEntryReadyToBeFormatted() {
        LOGGER.debug(String.format("Attempt to input text entry into the empty field: %s",
                entryReadyToBeFormatted));
        entryReadyToBeFormatted.click();
    }

    public void waitForLastEntryCreatedOrUpdatedOn() {
        LOGGER.debug(String.format(
                "Attempt get day - %s -, month - %s -, time - %s - the last entry was updated or created on.",
                dayLastEntryWasCreatedOrUpdatedOn,
                monthLastEntryWasCreatedOrUpdatedOn,
                timeLastEntryWasCreatedOrUpdatedOn));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//div[contains(@class, 'day ng-binding')])[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//div[contains(@class, 'month ng-binding')])[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//div[contains(@class, 'time ng-binding')])[1]")));
    }

    public String getDateLastEntryWasCreatedOrUpdatedOn() {
        return dayLastEntryWasCreatedOrUpdatedOn.getText().trim().
                concat(monthLastEntryWasCreatedOrUpdatedOn.getText().trim().
                        concat(timeLastEntryWasCreatedOrUpdatedOn.getText().trim()));
    }

    public void inputSearchText() {
        LOGGER.debug(String.format("Attempt to send text to search for an entry: %s", text));
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        LOGGER.debug(String.format("Attempt to click on 'Search' button: %s", searchButton));
        searchButton.click();
    }

    public void clickChangeDateOrTimeButton() {
        LOGGER.debug(String.format("Attempt to click on 'Change Date or Time' button: %s", changeDateOrTimeButton));
        changeDateOrTimeButton.click();
    }

    public void clickToSeeDateOptionsToSelect() {
        LOGGER.debug(String.format("Attempt to click on 'Date Options': %s", dateOptions));
        dateOptions.click();
    }


    public void clickToSelectDay10() {
        LOGGER.debug(String.format("Attempt to click on 'Day 10': %s", day10));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//table[contains(@class,  table-condensed)])[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[text()='10'])[1]")))
                .click();
    }

    public void clickOKButton() {
        LOGGER.debug(String.format("Attempt to click on 'OK' button in change date area: %s", changeDateOKButton));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[contains(@ng-click, 'changeDate()')]")))
                .click();
    }

    public void clickSelectDateForFilteringField() {
        LOGGER.debug(String.format("Attempt to select date for entries filtering: %s", selectDateForFilteringField));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(selectDateForFilteringField));
        selectDateForFilteringField.click();
    }

    public void clickOnTheLastEntry() {
        LOGGER.debug(String.format("Attempt to click on the last entry: %s", lastEntry));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                        "(//div[contains(@class, 'body')])[1]")))
                .click();
    }

    public String getTextOfLastEntry() {
        LOGGER.debug(String.format("Attempt to get text of the last entry: %s", lastEntry));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "(//div[contains(@class, 'body')])[1]")));
        return lastEntry.getText();
    }

    public void inputNewTagName() {
        LOGGER.debug(String.format("Attempt to send new tag name into an empty field: %s", tag, createNewTagField));
        createNewTagField.sendKeys(tag);
    }

    public void clickCreateTagOKButton() {
        LOGGER.debug(String.format("Attempt to click on 'OK' button to create a new tag name: %s", createTagOKButton));
        createTagOKButton.click();
    }

    public List<WebElement> getTagNamesAssignedToEntry() {
        LOGGER.debug(String.format("Attempt to get a list of all assigned to the last entry tag names: %s",
                allAssignedTags));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfAllElements(allAssignedTags));
        return allAssignedTags;
    }

    public boolean isTagNameAssignedToEntry() {
        LOGGER.debug(String.format("Check whether created tag name (%s) is assigned to the entry or not.", tag));
        List<WebElement> tags = getTagNamesAssignedToEntry();
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getText().equals(tag)) {
                return true;
            }
        }
        return false;
    }

    public List<WebElement> getDaysOfAllFilteredEntries() {
        LOGGER.debug(String.format("Attempt to get a list of days of all filtered entries: %s",
                daysOfAllFilteredEntries));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector(".entry-container .calendar-date :nth-child(1)")));
        return daysOfAllFilteredEntries;
    }

    public boolean areAllDaysOfFilteredEntriesEqualTo10() {
        LOGGER.debug(String.format("Check whether filtered entries days are equal to 10."));
        List<WebElement> days = getDaysOfAllFilteredEntries();
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).getText().trim().equals("10")) {
                return true;
            }
        }
        return false;
    }

    public void clickImageButton() {
        LOGGER.debug(String.format("Attempt to click 'Insert an image' button: %s.", imageButton));
        imageButton.click();
    }

    public void switchToChooseFileFrame() {
        LOGGER.debug(String.format("Attempt to switch to frame to be able to select a file: %s.", chooseFileFrame));
        driver.switchTo().frame(chooseFileFrame);
    }

    public void switchToMainFrame() {
        LOGGER.debug("Attempt to switch to main frame.");
        driver.switchTo().parentFrame();
    }

    public void clickChooseFileButton() {
        LOGGER.debug(String.format("Attempt to click on 'Choose File' button: %s", chooseFileButton));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", chooseFileButton);
    }

    public void sendFilePath() {
        LOGGER.debug("Attempt to send image path.");
        String path = System.getProperty("user.dir").
                concat("/src/test/resources/Screenshot 2022-08-31 at 20.51.42.png");
        chooseFileButton.sendKeys(path);
    }

    public void clickImagePropertiesOKButton() {
        LOGGER.debug(String.format("Attempt to click on 'OK' button: %s.", imagePropertiesOKButton));
        imagePropertiesOKButton.click();
    }

    public boolean isImageUploaded() {
        LOGGER.debug(String.format("Check whether image (%s) is uploaded or not.", uploadedImage));
        return uploadedImage.isDisplayed();
    }

    public void selectTextOfEntry() {
        LOGGER.debug("Attempt to select/highlight text of the  entry.");
        inputTextField.sendKeys(Keys.COMMAND, "a");
    }

    public void clickBoldButton() {
        LOGGER.debug(String.format("Attempt to click 'Bold' button: %s", boldButton));
        boldButton.click();
    }

    public String getEntryBoldText() {
        LOGGER.debug(String.format("Attempt to get bold text of the entry: %s", textInBold));
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(textInBold));
        return textInBold.getText();
    }
}
