package drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.util.Arrays;

public class OperaDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
        OperaOptions options = new OperaOptions();
        options.addArguments("--headless", "--disable-notifications");

        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
    }
}
