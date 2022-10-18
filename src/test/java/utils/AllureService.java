package utils;

import drivermanager.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureService {

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        TakesScreenshot screenShot = ((TakesScreenshot) driver);
        return screenShot.getScreenshotAs(OutputType.BYTES);
    }

    @Attachment
    public String getSystemName() {
        return System.getProperty("os.name");
    }

    @Attachment(value = "Browser type", type = "text/plain")
    public String getBrowserType(DriverManager driverManager) {
        return driverManager.getBrowserType();
    }

    @Attachment(value = "Browser version", type = "text/plain")
    public String getBrowserVersion(DriverManager driverManager) {
        return driverManager.getBrowserVersion();
    }
}
