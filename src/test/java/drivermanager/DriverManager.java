package drivermanager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public abstract class DriverManager {

    protected WebDriver driver;

    public abstract void createDriver();

    public WebDriver getDriver() {
        return driver;
    }

    public void startMaximize() {
        driver.manage().window().maximize();
    }

    public void setTimeout() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void removeTimeout() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public String getBrowserVersion() {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserVersion = caps.getVersion();
        return browserVersion;
    }

    public String getBrowserType() {
        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = caps.getBrowserName();
        return browserName;
    }

    public void quitDriver() {
        driver.quit();
    }
}
