package config;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;

    private WebDriver createDriver(String browser) {
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());
        switch (browserType) {
            case CHROME:
                driver.set(new ChromeDriverManager().createDriver());
                break;
            case FIREFOX:
                driver.set(new FirefoxDriverManager().createDriver());
                break;
            default:
                throw new RuntimeException("Incorrect Browser Name");
        }
        return driver.get();
    }

    public WebDriver getDriver(String browser) {
        if (null == driver.get()) {
            driver.set(this.createDriver(browser));
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);

        return driver.get();
    }

    public void quitDriver() {
        if (null != driver.get()) {
            driver.get().quit();
            driver.remove();
        }
    }

    public enum BrowserList {
        CHROME, FIREFOX
    }
}

