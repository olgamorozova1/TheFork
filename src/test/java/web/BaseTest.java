package web;

import config.DriverFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import utils.FileReader;


public class BaseTest {
    protected static WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();

    @Before
    public void setUp() {
        driver = driverFactory.getDriver(FileReader.readProperties("browser"),
                                         FileReader.readProperties("os"));
        driver.get(FileReader.readProperties("web_app_url"));
    }

    @After
    public void tearDown() {
        driverFactory.quitDriver();
    }
}
