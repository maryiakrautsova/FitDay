package tests;

import frequentlyusedmethods.LoginSteps;
import models.NewAccountRegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountRegistrationPage;
import pages.LoginPage;
import testdata.PrepareNewAccountData;
import utils.RetryAnalyzer;

public class UserRegistrationTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(UserRegistrationTest.class.getName());

    @Test(priority = 1,
            description = "this test validates a new user can register in the system test",
            retryAnalyzer = RetryAnalyzer.class)
    public void newAccountCreationTest() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s is initialized.", LoginSteps.class.getName()));
        LOGGER.info("Attempt to open login page.");
        loginPage.openLoginPage();
        LOGGER.info("Proceed with clicking on 'Register' link.");
        loginPage.clickRegisterLink();

        AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
        LOGGER.info(String.format("Page %s is initialized.", AccountRegistrationPage.class.getName()));
        LOGGER.info("Attempt to fill in fields for registration.");
        NewAccountRegistrationModel registrationModel = PrepareNewAccountData.getValidRegistrationData();
        accountRegistrationPage.fillInAccountRegistrationForm(registrationModel);
        LOGGER.info("Attempt to accept terms of use.");
        accountRegistrationPage.acceptTermsOfUse();
        LOGGER.info("Attempt to accept terms of password recovery.");
        accountRegistrationPage.acceptTermsOfPasswordRecovery();
        LOGGER.info("Proceed with clicking on 'OK' button.");
        accountRegistrationPage.clickOKButton();
        LOGGER.info("Check a new user is registered.");
        Assert.assertTrue(accountRegistrationPage.isUserSuccessfullyRegistered(),
                "User is not registered. Check input data.");
    }
}
