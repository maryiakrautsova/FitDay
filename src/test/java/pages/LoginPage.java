package pages;

import constants.Credentials;
import constants.Urls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

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
        driver.get(Urls.LOGIN_AND_REGISTRATION_PAGE_URL);
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void fillInUserInputField() {
        userInput.sendKeys(Credentials.USERNAME);
    }

    public void fillInPasswordInputField() {
        passwordInput.sendKeys(Credentials.PASSWORD);
    }

    public void clickLoginButton() {
        loginButton.click();
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
}
