package drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        driver = new SafariDriver();
        //SafariOptions options = new SafariOptions();
        //driver = new SafariDriver(options);
    }
}
