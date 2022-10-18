package pages;

import models.NewAccountRegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(AccountRegistrationPage.class.getName());


    @FindBy(id = "registration_email")
    private WebElement emailInput;

    @FindBy(id = "registration_password")
    private WebElement passwordInput;

    @FindBy(id = "registration_password_confirmation")
    private WebElement passwordConfirmationInput;

    @FindBy(id = "registration_password_hint")
    private WebElement passwordHintInput;

    @FindBy(xpath = "//div[text()='OK']")
    private WebElement OKButton;

    @FindBy(id = "registration_terms_of_use")
    private WebElement termsOfUseCheckbox;

    @FindBy(id = "registration_lost_password_warning_registered")
    private WebElement termsOfPasswordRecovery;

    @FindBy(xpath = "//h1[text()='User registered']")
    private WebElement userIsRegisteredConfirmation;

    public void fillInAccountRegistrationForm(NewAccountRegistrationModel newAccount) {
        LOGGER.debug(String.format("Attempt to send email: %s.", newAccount.getEmail()));
        emailInput.sendKeys(newAccount.getEmail());
        LOGGER.debug(String.format("Attempt to send password: %s.", newAccount.getPassword()));
        passwordInput.sendKeys(newAccount.getPassword());
        LOGGER.debug(String.format("Attempt to send password confirmation: %s.", newAccount.getPasswordConfirmation()));
        passwordConfirmationInput.sendKeys(newAccount.getPasswordConfirmation());
        LOGGER.debug(String.format("Attempt to send password hint: %s.", newAccount.getPasswordHint()));
        passwordHintInput.sendKeys(newAccount.getPasswordHint());
    }

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOKButton() {
        LOGGER.debug(String.format("Attempt to click 'OK' button: %s.", OKButton));
        OKButton.click();
    }

    public void acceptTermsOfUse() {
        LOGGER.debug(String.format("Attempt to accept terms of use: %s.", termsOfUseCheckbox));
        termsOfUseCheckbox.click();
    }

    public void acceptTermsOfPasswordRecovery() {
        LOGGER.debug(String.format("Attempt to accept terms of password recovery: %s.", termsOfPasswordRecovery));
        termsOfPasswordRecovery.click();
    }

    public boolean isUserSuccessfullyRegistered() {
        LOGGER.debug(String.format("Check whether user is registered or not: %s.", userIsRegisteredConfirmation));
        return userIsRegisteredConfirmation.isDisplayed();
    }
}
