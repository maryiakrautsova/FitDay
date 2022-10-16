package pages;

import models.NewAccountRegistrationModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

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
        emailInput.sendKeys(newAccount.getEmail());
        passwordInput.sendKeys(newAccount.getPassword());
        passwordConfirmationInput.sendKeys(newAccount.getPasswordConfirmation());
        passwordHintInput.sendKeys(newAccount.getPasswordHint());
    }

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOKButton() {
        OKButton.click();
    }

    public void acceptTermsOfUse() {
        termsOfUseCheckbox.click();
    }

    public void acceptTermsOfPasswordRecovery() {
        termsOfPasswordRecovery.click();
    }

    public boolean isUserSuccessfullyRegistered() {
        return userIsRegisteredConfirmation.isDisplayed();
    }
}
