package frequentlyusedmethods;

import drivermanager.DriverManager;
import pages.LoginPage;

public class LoginSteps {

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
