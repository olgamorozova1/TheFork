package config;

import org.openqa.selenium.WebDriver;

public interface Factory {
    WebDriver createDriver(DriverFactory.OSList OSType);
}
