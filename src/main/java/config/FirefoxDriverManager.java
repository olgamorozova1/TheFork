package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxDriverManager implements Factory{
    @Override
    public WebDriver createDriver(DriverFactory.OSList OSType) {
            switch (OSType) {
                case MAC:
                    System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/mac/geckodriver.exe");
                    break;
                case WIN:
                    System.setProperty("webdriver.gecko.driver", ".src/main/resources/drivers/win/geckodriver.exe");
                    break;
                default:
                    throw new RuntimeException("Incorrect OS");
            }
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.desktop-notification", 1);
        DesiredCapabilities capabilities= DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        return new FirefoxDriver(capabilities);
    }
}
