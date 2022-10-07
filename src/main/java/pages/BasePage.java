package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By element) {
        driver.findElement(element).click();
    }

    public void fillInput(By element, String text) {
        driver.findElement(element).sendKeys(text);
    }

    public String getInfoFromElement(By element) {
        return driver.findElement(element).getAttribute("value");
    }

    public String getSelectedInfo(By selectElement) {
        Select select = new Select(driver.findElement(selectElement));
        WebElement option = select.getFirstSelectedOption();
        return option.getText();
    }

    public boolean isElementExist(By element) {
        return (driver.findElements(element).size() > 0);
    }
}
