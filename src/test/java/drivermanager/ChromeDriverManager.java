package drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--window-size=1920,1200");
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");

        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
    }
}
