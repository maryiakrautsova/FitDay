package pages;

import constants.Credentials;
import constants.Urls;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerLink;

    @FindBy(id = "login")
    private WebElement userInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//div[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[text()='Cancel']")
    private WebElement cancelModalWindowButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s.", Urls.LOGIN_AND_REGISTRATION_PAGE_URL));
        driver.get(Urls.LOGIN_AND_REGISTRATION_PAGE_URL);
    }

    public void clickRegisterLink() {
        LOGGER.debug(String.format("Attempt to click on Registration Link.", registerLink));
        registerLink.click();
    }

    public void fillInUserInputField() {
        LOGGER.debug(String.format("Attempt to send Username: %s.", Credentials.USERNAME));
        userInput.sendKeys(Credentials.USERNAME);
    }

    public void fillInPasswordInputField() {
        LOGGER.debug(String.format("Attempt to send Password: %s.", Credentials.PASSWORD));
        passwordInput.sendKeys(Credentials.PASSWORD);
    }

    public void clickLoginButton() {
        LOGGER.debug(String.format("Attempt to click on Login Button.", loginButton));
        loginButton.click();
    }

    public void waitAndCloseModalWindow() {
        LOGGER.debug(String.format("Wait and close modal window in case it pops up: %s", cancelModalWindowButton));
        WebDriverWait wait = new WebDriverWait(driver, 10);

        try {
            wait.until(ExpectedConditions.
                    visibilityOf(cancelModalWindowButton));
            cancelModalWindowButton.click();
        } catch (Throwable e) {

        }
    }
}
