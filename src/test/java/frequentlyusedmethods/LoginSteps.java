package frequentlyusedmethods;

import drivermanager.DriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import pages.LoginPage;

public class LoginSteps {

    private static final Logger LOGGER = LogManager.getLogger(LoginSteps.class.getName());

    public void userLogin(DriverManager driverManager) {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.openLoginPage();
        loginPage.fillInUserInputField();
        loginPage.fillInPasswordInputField();
        loginPage.clickLoginButton();
        driverManager.removeTimeout();
        loginPage.waitAndCloseModalWindow();
        driverManager.setTimeout();
    }
}
