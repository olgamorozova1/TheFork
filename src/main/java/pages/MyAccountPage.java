package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {

    public static By myPersonalInformationButton = By.xpath("//button[contains(text(),'My personal information')]");
    public static By firstNameInput = By.xpath("//input[@name='firstName']");
    public static By lastNameInput = By.xpath("//input[@name='lastName']");
    public static By phoneCodeSelect = By.xpath("//select[@id='PHONE_CODE_FIELD']");
    public static By phoneNumberInput = By.xpath("//input[@name='phoneNumber.nationalNumber']");

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public void openUserAccount() {
        click(myPersonalInformationButton);
    }

    public String getFirstNameInfo() {
        return getInfoFromElement(firstNameInput);
    }

    public String getLastNameInfo() {
        return getInfoFromElement(lastNameInput);
    }

    public String getPhoneNumberInputInfo() {
        return getInfoFromElement(phoneNumberInput);
    }

    public String getPhoneCodeInfo() {
        return getSelectedInfo(phoneCodeSelect);
    }
}
