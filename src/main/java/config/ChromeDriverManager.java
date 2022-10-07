package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverManager implements Factory{
    @Override
    public WebDriver createDriver(DriverFactory.OSList OSType) {
        switch (OSType) {
            case MAC:
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/mac/chromedriver");
                break;
            case WIN:
                System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/win/chromedriver.exe");
                break;
            default:
                throw new RuntimeException("Incorrect OS");
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("disable-infobars");
        return new ChromeDriver(options);
    }
}
