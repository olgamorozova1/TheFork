package config;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    private WebDriver createDriver(String browser, String OS) {
        BrowserList browserType = BrowserList.valueOf(browser.toUpperCase());
        OSList osType = OSList.valueOf(OS.toUpperCase());
        switch (browserType) {
            case CHROME:
                driver.set(new ChromeDriverManager().createDriver(osType));
                break;
            case FIREFOX:
                driver.set(new FirefoxDriverManager().createDriver(osType));
                break;
            default:
                throw new RuntimeException("Incorrect Browser Name");
        }
        return driver.get();
    }

    public WebDriver getDriver(String browser, String OS) {
        if (null == driver.get()) {
            driver.set(this.createDriver(browser, OS) );
        }
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);

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

    public enum OSList {
        MAC, WIN
    }
}

