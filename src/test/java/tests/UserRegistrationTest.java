package tests;

import models.NewAccountRegistrationModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountRegistrationPage;
import pages.LoginPage;
import testdata.PrepareNewAccountData;
import utils.RetryAnalyzer;

public class UserRegistrationTest extends BaseTest {
    @Test(priority = 1,
            description = "this test validates a new user can register in the system test",
            retryAnalyzer = RetryAnalyzer.class)
    public void newAccountCreationTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickRegisterLink();
        AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
        NewAccountRegistrationModel registrationModel = PrepareNewAccountData.getValidRegistrationData();
        accountRegistrationPage.fillInAccountRegistrationForm(registrationModel);
        accountRegistrationPage.acceptTermsOfUse();
        accountRegistrationPage.acceptTermsOfPasswordRecovery();
        accountRegistrationPage.clickOKButton();
        Assert.assertTrue(accountRegistrationPage.isUserSuccessfullyRegistered(),
                "User is not registered. Check input data.");
    }
}
