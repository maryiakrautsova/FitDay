package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FakeMessageGenerator;

import java.util.List;


public class EntriesPage extends BasePage {

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
    // (//div[contains(@class, 'body ')])[1]

    @FindBy(xpath = "(//p)[1]")
    private WebElement entryReadyToBeFormatted;

    @FindBy(xpath = "(//div[contains(@class, 'body')])[1]")
    private WebElement lastEntry;

    @FindBy(css = ".cke_savetoggle_text")
    private WebElement savedIndicator;

    @FindBy(xpath = "//div[text()='Log out']")
    private WebElement cancelModalWindowButton;

    @FindBy(xpath = "(//input[contains(@ng-change, 'updateSelectionState()')])[1]")
    private WebElement lastEntryCheckbox;

    @FindBy(id = "delete-entries")
    private WebElement deleteSelectedEntriesButton;

    @FindBy(xpath = "(//div[contains(@class, 'day ng-binding')])[1]")
    private WebElement dayLastEntryWasCreatedOrUpdated;

    @FindBy(xpath = "(//div[contains(@class, 'month ng-binding')])[1]")
    private WebElement monthLastEntryWasCreatedOrUpdated;

    @FindBy(xpath = "(//div[contains(@class, 'time ng-binding')])[1]")
    private WebElement timeLastEntryWasCreatedOrUpdated;

    @FindBy(id = "appendedInputButton")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(@title, 'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(@class,'link_text_long')]")
    private WebElement changeDateOrTimeButton;

    @FindBy(id = "date")
    private WebElement dateOptions;

    @FindBy(xpath = "//td[text()='20']")
    private WebElement day20;

    @FindBy(xpath = "(//td[text()='5'])[1]")
    private WebElement day5;

    @FindBy(xpath = "//button[contains(@ng-click, 'changeDate()')]")
    private WebElement changeDateOKButton;

    @FindBy(id = "datepicker")
    private WebElement selectDateForFilteringField;

    @FindBy(id = "new-tag")
    private WebElement createNewTagField;

    @FindBy(xpath = "(//div[contains(@class, 'btn-text-content')])[2]")
    private WebElement createTagOKButton;

    @FindBy(css = ".assigned-tags span a")
    private List <WebElement> allAssignedTags;

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

    @FindBy(xpath = "//a[contains(@title, 'Text Color')]")
    private WebElement changeTextColourButton;

    @FindBy(css = "p > strong")
    private WebElement textInBold;

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCreateAnEntryButtonVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            wait.until(ExpectedConditions.visibilityOf(createAnEntryButton));
        } catch (WebDriverException e) {
            return false;
        }
        return true;
    }

    public void clickCreateAnEntryButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.
                visibilityOf(createAnEntryButton));
        createAnEntryButton.click();
    }

    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.
                visibilityOf(logoutButton));
        logoutButton.click();
    }

    public boolean isLogoutButtonPresent() {
        return logoutButton.isDisplayed();
    }

    public void waitAndCloseModalWindow() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            wait.until(ExpectedConditions.
                    visibilityOf(cancelModalWindowButton));
            cancelModalWindowButton.click();
        } catch (Throwable e) {

        }
    }

    public void inputText() {
        inputTextField.sendKeys(text);
    }

    public void clickBackToOverviewButton() {
        backToOverviewButton.click();
    }

    public String getTextOfTheExistingEntry() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(textAreaOfTheExistingEntry));
        return textAreaOfTheExistingEntry.getText();
    }

    public void waitForTextIsSavedIndicator() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.textToBePresentInElement(savedIndicator, "saved"));
    }

    public void tickLastEntryCheckbox() {
        lastEntryCheckbox.click();
    }

    public void clickDeleteSelectedEntriesButton() {
        deleteSelectedEntriesButton.click();
    }

    public void confirmDeletionOfSelectedEntries() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public String getTextOfEntryReadyToBeFormatted() {
        return entryReadyToBeFormatted.getText();
    }

    public String getDateLastEntryWasCreatedOrUpdated() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(timeLastEntryWasCreatedOrUpdated));
        return dayLastEntryWasCreatedOrUpdated.getText().trim().
                concat(monthLastEntryWasCreatedOrUpdated.getText().trim().
                        concat(timeLastEntryWasCreatedOrUpdated.getText().trim()));
    }

    public void inputSearchText() {
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickChangeDateOrTimeButton() {
        changeDateOrTimeButton.click();
    }

    public void clickToSeeDateOptionsToSelect() {
        dateOptions.click();
    }

    public void clickToSelectDay20() {
        day20.click();
    }

    public void clickToSelectDay5() {
        day5.click();
    }

    public void clickOKButton() {
        changeDateOKButton.click();
    }

    public void clickSelectDateForFilteringField() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(selectDateForFilteringField));
        selectDateForFilteringField.click();
    }

    public void clickOnTheLastEntry() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(lastEntry));
        lastEntry.click();
    }

    public String getTextOfLastEntry() {
        return lastEntry.getText();
    }

    public void clickCreateNewTagField() {
        createNewTagField.sendKeys(tag);
    }

    public String getTag() {
        return tag;
    }

    public void clickCreateTagOKButton() {
        createTagOKButton.click();
    }

    public List<WebElement> getTagNamesAssignedToEntry() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(allAssignedTags));
        return allAssignedTags;
    }

    public boolean isTagNameAssignedToEntry() {
        List<WebElement> tags = getTagNamesAssignedToEntry();
        for (int i = 0; i < tags.size(); i++){
            if (tags.get(i).getText().equals(tag)){
                return true;
            }
        }
        return false;
    }

    public void clickImageButton() {
        imageButton.click();
    }

    public void switchToChooseFileFrame() {
        driver.switchTo().frame(chooseFileFrame);
    }

    public void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }

    public void clickChooseFileButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", chooseFileButton);
    }

    public void sendFilePath() {
        String path = System.getProperty("user.dir").
                concat("/src/test/resources/Screenshot 2022-08-31 at 20.51.42.png");
        chooseFileButton.sendKeys(path);
    }

    public void clickImagePropertiesOKButton() {
        imagePropertiesOKButton.click();
    }

    public boolean isImageUploaded() {
        return uploadedImage.isDisplayed();
    }

    public void selectTextOfEntry() {
        inputTextField.sendKeys(Keys.COMMAND, "a");
    }

    public void clickBoldButton() {
        boldButton.click();
    }

    public String getEntryBoldText() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(textInBold));
        return textInBold.getText();
    }
}
